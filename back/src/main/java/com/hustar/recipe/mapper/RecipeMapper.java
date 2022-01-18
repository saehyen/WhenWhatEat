package com.hustar.recipe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hustar.recipe.vo.RecipeVO;

@Mapper
public interface RecipeMapper {
	
	public List<RecipeVO> getRecipeList();

}
