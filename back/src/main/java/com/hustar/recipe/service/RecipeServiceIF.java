package com.hustar.recipe.service;

import java.util.List;
import java.util.Optional;

import com.hustar.recipe.vo.RecipeDetailVO;
import com.hustar.recipe.vo.RecipeVO;

public interface RecipeServiceIF {
	
	public List<RecipeVO> getRecipeList();
	
	public RecipeVO getRecipeDetailList(Long id);
	
	public List<RecipeDetailVO> getRecipeDetail(Long id);
}
