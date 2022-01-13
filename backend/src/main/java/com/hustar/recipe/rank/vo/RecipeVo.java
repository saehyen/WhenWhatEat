package com.hustar.recipe.rank.vo;

import lombok.Data;

@Data
public class RecipeVo {
	private int id;
	private String name;
	private String img;
	private String summary;
	private String info1;
	private String info2;
	private String info3;
	private double rate;
	private int rate_count;
	private int views;
	private String post_date;
	
	private int startIndex;
	private int cntPerPage;
}
