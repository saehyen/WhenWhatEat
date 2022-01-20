package com.hustar.recipe.service;

import java.util.List;

import com.hustar.recipe.vo.MyRefrigeratorVO;

public interface MyRefrigeratorServiceIF {
	
	public List<MyRefrigeratorVO> getMyRefrigerator(Long uid);
	
	public Boolean registMyRefrigerator(MyRefrigeratorVO vo);

	public Boolean deleteMyRefrigerator(MyRefrigeratorVO vo);

}
