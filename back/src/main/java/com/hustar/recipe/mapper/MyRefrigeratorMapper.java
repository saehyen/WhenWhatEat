package com.hustar.recipe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hustar.recipe.vo.MyRefrigeratorVO;

@Mapper
public interface MyRefrigeratorMapper {
	
	public List<MyRefrigeratorVO> getMyRefrigerator(Long uid);
	
	public Integer registMyRefrigerator(MyRefrigeratorVO vo);

	public int deleteMyRefrigerator(MyRefrigeratorVO vo);

}
