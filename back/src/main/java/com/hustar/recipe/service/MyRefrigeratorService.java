package com.hustar.recipe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.MyRefrigeratorMapper;
import com.hustar.recipe.vo.MyRefrigeratorVO;

@Service
public class MyRefrigeratorService implements MyRefrigeratorServiceIF {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<MyRefrigeratorVO> getMyRefrigerator(Long uid) {
		
		List<MyRefrigeratorVO> myRefrigerator = new ArrayList<MyRefrigeratorVO>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MyRefrigeratorMapper mapper = session.getMapper(MyRefrigeratorMapper.class);

			myRefrigerator = mapper.getMyRefrigerator(uid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myRefrigerator;
	}
	
	
	@Override
	public Boolean registMyRefrigerator(MyRefrigeratorVO vo) {
		
		vo.setProd_post(new Date());
		
		boolean result = false;
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MyRefrigeratorMapper mapper = session.getMapper(MyRefrigeratorMapper.class);

			// 매퍼의 결과를 담을 변수
			Integer mapperResult = 0;
			
			// 성공시 1이 반환됩니다.
			mapperResult = mapper.registMyRefrigerator(vo);
			
			//정상 동작시 return 값을 true
			if (mapperResult > 0) {
				result = true;
			}
			//정상 동작이 아닐 시 return 값을 false
			else {
				result = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	@Override
	public Boolean deleteMyRefrigerator(MyRefrigeratorVO vo) {
		
		boolean result = false;
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MyRefrigeratorMapper mapper = session.getMapper(MyRefrigeratorMapper.class);

			// 매퍼의 결과를 담을 변수
			int mapperResult = 0;
			
			// 성공시 1이 반환됩니다.
			mapperResult = mapper.deleteMyRefrigerator(vo);
			
			//정상 동작시 return 값을 true
			if (mapperResult > 0) {
				result = true;
			}
			//정상 동작이 아닐 시 return 값을 false
			else {
				result = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	

}
