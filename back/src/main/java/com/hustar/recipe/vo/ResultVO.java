package com.hustar.recipe.vo;

import lombok.Data;

@Data
public class ResultVO {
	
	Object result;
	boolean success;
	
	public ResultVO(boolean success, Object result) {
		this.result = result;
		this.success = false;
	}

}
