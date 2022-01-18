package com.hustar.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.RecipeMapper;
import com.hustar.recipe.vo.RecipeDetailVO;
import com.hustar.recipe.vo.RecipeVO;

@Service
public class RecipeService implements RecipeServiceIF {

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
	
	public RecipeVO getRecipeDetailList(Long id) {
		RecipeVO recipe = new RecipeVO();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
 
			recipe = mapper.getRecipeDetailList(id);
 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipe;
	}
	
	public List<RecipeDetailVO> getRecipeDetail(Long id) {
//		RecipeDetailVO recipeDetail = new RecipeDetailVO();
		List<RecipeDetailVO> recipeDetail = new ArrayList<RecipeDetailVO>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
 
			recipeDetail = mapper.getRecipeDetail(id);
 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipeDetail;
	}
	
	



}
