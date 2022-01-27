package com.hustar.recipe.vo;

import lombok.Data;

@Data
public class RateVO {
	private Long rate_idx;
	private Long uid;
	private double rate;
	private Long recipe_id;

}
