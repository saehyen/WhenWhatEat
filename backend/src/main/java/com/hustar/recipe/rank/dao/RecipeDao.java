package com.hustar.recipe.rank.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hustar.recipe.rank.vo.RecipeVo;

@Service(value="recipeDao")
public class RecipeDao {
	
	@Resource(name="recipeMapper")
	private RecipeMapper recipeMapper;
	
	public int getRecipeListCount() {
		return recipeMapper.recipeListCount();
	}
	public List<RecipeVo> getRecipeList(RecipeVo recipe){
		return recipeMapper.recipeList(recipe);
	}
	public RecipeVo getRecipeOne(String id) {
		return recipeMapper.recipeOne(id);
	}
	
}
