package com.hustar.recipe.rank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hustar.recipe.rank.vo.RecipeVo;

@Repository(value="recipeMapper")
public interface RecipeMapper {
	public int recipeListCount();
	public List<RecipeVo> recipeList(RecipeVo recipeVo);
	public RecipeVo recipeOne(String id);
	
//	public int recipeInsert(RecipeVo recipe);
//	public int recipeUpdate(RecipeVo recipe);
//	public int recipeDelete(String id);
}
