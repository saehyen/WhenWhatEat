package com.hustar.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hustar.recipe.mapper.RateMapper;
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
	
	public List<RecipeVO> getRank() {

		List<RecipeVO> recipeViews = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			recipeViews = mapper.getRecipeViews();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeViews;
	}
	
	@Override
	public List<RecipeVO> categoryList(List<String> category, String info2) {

		System.out.println(category);
		List<RecipeVO> categoryRecipe = new ArrayList<RecipeVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			RecipeMapper mapper = session.getMapper(RecipeMapper.class);

			categoryRecipe = mapper.categoryList(category, info2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(categoryRecipe);
		return categoryRecipe;
	}

	@Override
	public Boolean updateRate(Long uid, Long recipe_id, double rate) {
		
		System.out.println("uid: " + uid + "recipe_id: " + recipe_id + "rate: " + rate);
		Boolean result = false;
		Integer mapperResult = 0;
		
		try {
			SqlSession sessionUser = sqlSessionFactory.openSession();
			RateMapper rateMapper = sessionUser.getMapper(RateMapper.class);
			mapperResult = rateMapper.insertRate(uid, recipe_id, rate);
		}catch(PersistenceException e) {
			mapperResult = 0;
		}
		
		
		if(mapperResult > 0) {
			SqlSession sessionRateTotal = sqlSessionFactory.openSession();
			RecipeMapper rateTotalMapper = sessionRateTotal.getMapper(RecipeMapper.class);
			rateTotalMapper.updateRateTotal(recipe_id, rate);

			SqlSession sessionRateCount = sqlSessionFactory.openSession();
			RecipeMapper rateCountMapper = sessionRateCount.getMapper(RecipeMapper.class);
			rateCountMapper.updateRateCount(recipe_id);
			
			SqlSession sessionRateUpdate = sqlSessionFactory.openSession();
			RecipeMapper rateUpdateMapper = sessionRateUpdate.getMapper(RecipeMapper.class);
			rateUpdateMapper.updateRate(recipe_id);
		}
		
		if (mapperResult > 0) {
			result = true;
		}
		//정상 동작이 아닐 시 return 값을 false
		else {
			result = false;
		}
		
		
		return result;
		
		
	}
	
	
	
	
//	@Override
//	public List<RecipeVO> getRate(Long id) {
//		List<RecipeVO> recipe = new ArrayList<RecipeVO>();
//		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			RecipeMapper mapper = session.getMapper(RecipeMapper.class);
// 
//			recipe = mapper.getRecipeDetailList(id);
//			mapper.getRate(id);
// 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		
//		return recipe;
//	}
	
	
	
	
	
}
