package com.hustar.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.RecipeMapper;
import com.hustar.recipe.vo.RecipeVO;

@Service
public class RecipeService implements RecipeServiceIF{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<RecipeVO> getRecipeList() {

		List<RecipeVO> recipeList = new ArrayList<RecipeVO>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
			
				recipeList = mapper.getRecipeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}

}
