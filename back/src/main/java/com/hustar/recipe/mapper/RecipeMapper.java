package com.hustar.recipe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	public List<RecipeVO> categoryList(@Param("category") List<String> category, @Param("info2") String info2);
	
	public void updateRateTotal(@Param("id") Long id, @Param("rate") double rate);
	
	public void updateRateCount(@Param("id") Long id);
	
	public void updateRate(@Param("id") Long id);

//	public void getRate(Long id);

}
