package com.hustar.recipe.vo;

import java.util.Date;
import java.util.List;

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
	private Date post_date;

}
