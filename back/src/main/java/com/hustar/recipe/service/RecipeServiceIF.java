package com.hustar.recipe.service;

import java.util.List;
import java.util.Optional;

import com.hustar.recipe.vo.RecipeDetailVO;
import com.hustar.recipe.vo.RecipeVO;

public interface RecipeServiceIF {
	
	public List<RecipeVO> getRecipeList();
	
	public List<RecipeVO> getRecipeDetailList(Long id);
	
	public List<RecipeDetailVO> getRecipeDetail(Long detail_id);
	
	public List<RecipeVO> getTopRecipe();
	
	public List<RecipeVO> getRecommendRecipe(Long uid);
	
	public List<RecipeVO> getRecipeRate();
	
	public List<RecipeVO> getRecipeViews();
	
	public List<RecipeVO> categoryList(List<String> category, String info2);
	
	public Boolean updateRate(Long uid, Long recipe_id, double rate);

//	public List<RecipeVO> getRate(Long id);
}
