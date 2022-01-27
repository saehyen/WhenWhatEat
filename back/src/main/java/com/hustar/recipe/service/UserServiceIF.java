package com.hustar.recipe.service;

import java.util.List;

import com.hustar.recipe.vo.UserVO;

public interface UserServiceIF {
	
	public int checkLogin(String id, String password);
	
	public List<UserVO> getUser(String id);
	
	public Boolean registUser(String id, String password, String name);
	

}
