package com.hustar.recipe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MyRefrigeratorVO {
	
	private long detail_id;
	private long uid;
	private String prod_name;
	private String prod_img;
	private String prod_unit;
	private Date prod_post;
	private String prod_exp;

}
