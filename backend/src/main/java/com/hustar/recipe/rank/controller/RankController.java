package com.hustar.recipe.rank.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hustar.recipe.rank.dao.RecipeDao;
import com.hustar.recipe.rank.vo.PagingVo;
import com.hustar.recipe.rank.vo.RecipeVo;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class RankController {
	@Resource(name="recipeDao")
	private RecipeDao recipeDao;
	
	@RequestMapping(value="/recipeList")
	public String recipeList(@ModelAttribute("Recipe") RecipeVo recipe, 
			@RequestParam(defaultValue="1") int curPage,
			Model model) {
		//logger.info("noticList page");
		int listCnt = recipeDao.getRecipeListCount();
		PagingVo paging = new PagingVo(listCnt, curPage);
		recipe.setStartIndex(paging.getStartIndex());
		recipe.setCntPerPage(paging.getPageSize());
		
		List<RecipeVo> recipeList = recipeDao.getRecipeList(recipe);
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paging);
		return "recipe/recipeList";
	}
	@RequestMapping(value="/recipeRegi")
	public String recipeRegi() {
		System.out.println("recipe Regi page");
		return "recipe/recipeDetail";
	}
	@RequestMapping(value="/recipeDetail/{recipe_id}")
	public String recipeEdit(@PathVariable String id, Model model) {
		//System.out.println("recipe detail page [recipe_id={}]",id);
		model.addAttribute("recipe", recipeDao.getRecipeOne(id));
		return "recipe/recipeDetail";
	}
}
