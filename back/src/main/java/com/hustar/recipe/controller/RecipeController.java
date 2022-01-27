package com.hustar.recipe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hustar.recipe.service.RecipeService;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("recipe/")
public class RecipeController {

	private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	RecipeService recipeService;


	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recipe", method = {RequestMethod.POST , RequestMethod.GET})
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
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recipeInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO recipeDetailList(@RequestParam(value="id") Long id) {
		System.out.println(id);
//		System.out.println(vo.getId());
		
		ResultVO result = new ResultVO(false, null);
			result.setResult(recipeService.getRecipeDetailList(id));
			result.setSuccess(true);
			System.out.println(result);
		return result;
	}
	

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recipeDetail", method = {RequestMethod.POST, RequestMethod.GET})
//	@GetMapping("recipeDetail")
	public ResultVO recipeDetail(@RequestParam(value="id") Long id) {
		System.out.println("result recipeDetail");
		
		
		ResultVO result = new ResultVO(false, null);
			result.setResult(recipeService.getRecipeDetail(id));
			result.setSuccess(true);
		System.out.println(result);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "topRecipe", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO getTopRecipe() {

		System.out.println("result TopRecipe");
		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(recipeService.getTopRecipe());
			result.setSuccess(true);
		} catch (Exception e) {
			LOG.error("[Recipe] getTopRecipe : " + e.getMessage(), e);
		}
		System.out.println(result);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recommendRecipe", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO getRecommendRecipe(@RequestParam(value="uid") Long uid) {

		System.out.println("result RecommendRecipe");
		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(recipeService.getRecommendRecipe(uid));
			result.setSuccess(true);
		} catch (Exception e) {
			LOG.error("[Recipe] getTopRecipe : " + e.getMessage(), e);
		}
		System.out.println(result);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recipeRate", method = {RequestMethod.POST , RequestMethod.GET})
	public ResultVO getRecipeRecommend() {

		System.out.println("result recipeRate");
		ResultVO result = new ResultVO(false, null);

			result.setResult(recipeService.getRecipeRate());
			result.setSuccess(true);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "recipeViews", method = {RequestMethod.POST , RequestMethod.GET})
	public ResultVO getRecipeListViews() {

		System.out.println("result recipeViews");
		ResultVO result = new ResultVO(false, null);

			result.setResult(recipeService.getRecipeViews());
			result.setSuccess(true);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "category", method = {RequestMethod.POST , RequestMethod.GET})
	public ResultVO categoryRecipe(@RequestParam(value = "category") List<String> category,
									@RequestParam(value = "info2") String info2) {

		System.out.println(category);
		ResultVO result = new ResultVO(false, null);

			result.setResult(recipeService.categoryList(category, info2));
			result.setSuccess(true);
		return result;
	}
	
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "rate", method = { RequestMethod.POST, RequestMethod.GET })
	public int updateRate(@RequestParam(value = "uid") Long uid,
								@RequestParam(value = "recipe_id") Long recipe_id,
								@RequestParam(value = "rate") double rate) {

		System.out.println("rate update");
		Boolean result = false;
		
		result = recipeService.updateRate(uid, recipe_id, rate);
		
		System.out.println(result);
		
		if(result == true) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	
//	@CrossOrigin(origins = "*")
//	@ResponseBody
//	@RequestMapping(value = "getRate", method = {RequestMethod.POST , RequestMethod.GET})
//	public ResultVO getRecipeRecommend(@RequestParam(value="id") Long id) {
//
//		System.out.println("getRate");
//		ResultVO result = new ResultVO(false, null);
//
//			result.setResult(recipeService.getRate(id));
//			result.setSuccess(true);
//		return result;
//		
//	}
	
}
