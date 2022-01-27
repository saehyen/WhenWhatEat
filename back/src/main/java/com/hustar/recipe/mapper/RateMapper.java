package com.hustar.recipe.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RateMapper {
	
	public Integer insertRate(@Param("uid") Long uid, @Param("recipe_id") Long recipe_id, @Param("rate") double rate);

}
