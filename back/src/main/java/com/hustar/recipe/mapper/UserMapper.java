package com.hustar.recipe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hustar.recipe.vo.UserVO;

@Mapper
public interface UserMapper {
	
//	public List<String> Login(@Param("id") String id, @Param("password") String password);
	public UserVO Login(@Param("id") String id);
	
	public List<UserVO> getUser(@Param("id") String id);
	
	public Integer registUser(@Param("id")String id, @Param("password")String password, @Param("name")String name);
	
	

}
