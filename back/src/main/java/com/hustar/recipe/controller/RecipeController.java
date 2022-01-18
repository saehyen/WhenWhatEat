package com.hustar.recipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hustar.recipe.service.RecipeService;
import com.hustar.recipe.vo.RecipeVO;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("recipe/")
public class RecipeController {

	private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	RecipeService recipeService;


	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "get-recipe-list.do", method = RequestMethod.POST)
	public ResultVO getRecipeList() {

		System.out.println("result recipe");
		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(recipeService.getRecipeList());
			result.setSuccess(true);
		} catch (Exception e) {
			LOG.error("[Recipe] getRecipeList : " + e.getMessage(), e);
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "get-recipe-detail-list.do/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO recipeDetailList(@PathVariable("id") Long id) {
		System.out.println(id);
//		System.out.println(vo.getId());
		
		ResultVO result = new ResultVO(false, null);
		try {
			result.setResult(recipeService.getRecipeDetailList(id));
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("[Recipe] getRecipeDetail : " + e.getMessage(), e);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "get-recipe-detail.do/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO recipeDetail(@PathVariable("id") Long id) {
		System.out.println(id);
//		System.out.println(vo.getId());
		
		ResultVO result = new ResultVO(false, null);
		try {
			result.setResult(recipeService.getRecipeDetail(id));
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("[Recipe] getRecipeDetail : " + e.getMessage(), e);
		}
		return result;
	}
	
	

	

}
