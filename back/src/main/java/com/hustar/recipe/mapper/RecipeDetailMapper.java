package com.hustar.recipe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hustar.recipe.vo.RecipeDetailVO;

@Mapper
public interface RecipeDetailMapper {
	
	public List<RecipeDetailVO> getRecipeDetailList();

}
