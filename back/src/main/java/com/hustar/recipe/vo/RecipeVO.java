package com.hustar.recipe.vo;


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
	private int rate_count;
	private int views;
	private String post_date;
	private int rate_total;

}
