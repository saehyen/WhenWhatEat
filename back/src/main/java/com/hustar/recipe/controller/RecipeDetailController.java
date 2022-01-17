package com.hustar.recipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hustar.recipe.service.RecipeDetailService;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("recipeDetail/")
public class RecipeDetailController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RecipeDetailController.class);
	
	@Autowired
	RecipeDetailService recipeDetailService;
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "get-recipe-detail-list.do", method = RequestMethod.POST)
	public ResultVO getRecipeDetailList() {

		LOG.info("[POST] getRecipeDetailList");

		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(recipeDetailService.getRecipeDetailList());
			result.setSuccess(true);
		} catch (Exception e) {
			LOG.error("[Recipe] getRecipeDetailList : " + e.getMessage(), e);
		}

		return result;
	}

}
