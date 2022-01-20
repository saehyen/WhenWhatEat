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
	
	@Override
	public List<RecipeVO> getRecipeDetailList(Long id) {
		List<RecipeVO> recipe = new ArrayList<RecipeVO>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
 
			recipe = mapper.getRecipeDetailList(id);
			mapper.updateViews(id);
 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return recipe;
	}
	
	@Override
	public List<RecipeDetailVO> getRecipeDetail(Long detail_id) {
//		RecipeDetailVO recipeDetail = new RecipeDetailVO();
		List<RecipeDetailVO> recipeDetail = new ArrayList<RecipeDetailVO>();
		System.out.println(detail_id);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
 
			recipeDetail = mapper.getRecipeDetail(detail_id);
 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipeDetail;
	}
	
	@Override
	public List<RecipeVO> getTopRecipe() {

		List<RecipeVO> recipeList = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			recipeList = mapper.getTopRecipe();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}
	
	@Override
	public List<RecipeVO> getRecommendRecipe(Long uid) {

		List<RecipeVO> recipeList = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			recipeList = mapper.getRecommendRecipe(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeList;
	}

	
	@Override
	public List<RecipeVO> getRecipeRate() {

		List<RecipeVO> recipeRate = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			recipeRate = mapper.getRecipeRate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeRate;
	}
	
	@Override
	public List<RecipeVO> getRecipeViews() {

		List<RecipeVO> recipeViews = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			recipeViews = mapper.getRecipeViews();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeViews;
	}
	
}
