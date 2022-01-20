package com.hustar.recipe.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import com.hustar.recipe.vo.RecipeDetailVO;
import com.hustar.recipe.vo.RecipeVO;

@Mapper
public interface RecipeMapper {
	
	public List<RecipeVO> getRecipeList();
	
	public List<RecipeVO> getRecipeDetailList(Long id);
	
	public List<RecipeDetailVO> getRecipeDetail(Long detail_id);
	
	public List<RecipeVO> getTopRecipe();
	
	public List<RecipeVO> getRecommendRecipe(Long uid);
	
	public List<RecipeVO> getRecipeRate();
	
	public List<RecipeVO> getRecipeViews();
	
	public List<RecipeVO> updateViews(Long id);

}
