package com.hustar.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.RecipeDetailMapper;
import com.hustar.recipe.vo.RecipeDetailVO;

@Service
public class RecipeDetailService implements RecipeDetailServiceIF{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<RecipeDetailVO> getRecipeDetailList() {

		List<RecipeDetailVO> recipeDetailList = new ArrayList<RecipeDetailVO>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeDetailMapper mapper = session.getMapper(RecipeDetailMapper.class);
			
				recipeDetailList = mapper.getRecipeDetailList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeDetailList;
	}

}
