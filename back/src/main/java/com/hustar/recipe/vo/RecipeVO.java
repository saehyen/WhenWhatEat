package com.hustar.recipe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RecipeVO {
	private long id;
	private String name;
	private String img;
	private String summary;
	private String info1;
	private String info2;
	private String info3;
	private Double rate;
	private int rateCount;
	private int views;
	private Date postDate;

}
