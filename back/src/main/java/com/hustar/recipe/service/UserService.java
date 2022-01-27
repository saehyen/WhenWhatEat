package com.hustar.recipe.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.MyRefrigeratorMapper;
import com.hustar.recipe.mapper.RecipeMapper;
import com.hustar.recipe.mapper.UserMapper;
import com.hustar.recipe.vo.RecipeVO;
import com.hustar.recipe.vo.UserVO;

@Service
public class UserService implements UserServiceIF {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public int checkLogin(String id, String password) {

		UserVO user = new UserVO();
		int tmp = 0;
		// 쿼리수행 코드

		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);

			user = (UserVO) mapper.Login(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (user.getName().equals(id) == true || user.getPassword().equals(password) == true) {
				tmp = 0;
			}
			else if (user.getName().equals(id) == true || user.getPassword().equals(password) == false) {
				tmp = 2;
			}
		} catch (NullPointerException e) {
			tmp = 1;
		}

		return tmp;
	}
	
	@Override
	public List<UserVO> getUser(String id) {

		List<UserVO> userList = new ArrayList<UserVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);

			userList = mapper.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public Boolean registUser(String id, String password, String name) {
		
		boolean result = false;
		
		SqlSession session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);

			// 매퍼의 결과를 담을 변수
			Integer mapperResult = 0;
			
			
			try {
				mapperResult = mapper.registUser(id, password, name);
			}catch(PersistenceException e) {
				mapperResult = 0;
			}
				
		
				
			
			//정상 동작시 return 값을 true
			if (mapperResult > 0) {
				result = true;
			}
			//정상 동작이 아닐 시 return 값을 false
			else {
				result = false;
			}
		
		
		
		return result;
	}

	
	
	
}