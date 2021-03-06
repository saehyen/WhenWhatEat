package com.hustar.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hustar.recipe.service.MyRefrigeratorService;
import com.hustar.recipe.vo.MyRefrigeratorVO;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("myrefrigerator/")
public class MyRefrigeratorController {

	@Autowired
	MyRefrigeratorService myRefrigeratorService;

	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "myrefrigerator", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultVO getMyRefrigerator(@RequestParam(value="uid") Long uid) {

		System.out.println("result myrefrigerator");
		ResultVO result = new ResultVO(false, null);

		result.setResult(myRefrigeratorService.getMyRefrigerator(uid));
		result.setSuccess(true);
		System.out.println(result);

		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "infoIngre", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultVO detailIngre(@RequestParam(value="detail_id") Long detail_id) {

		System.out.println("result detail");
		ResultVO result = new ResultVO(false, null);

		result.setResult(myRefrigeratorService.infoIngre(detail_id));
		result.setSuccess(true);
		System.out.println(result);

		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "registMyRefrigerator", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultVO registMyRefrigerator(@RequestBody MyRefrigeratorVO vo) {

		System.out.println("result regist");
		ResultVO result = new ResultVO(false, null);

		result.setResult(myRefrigeratorService.registMyRefrigerator(vo));
		result.setSuccess(true);
		System.out.println(result);

		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "deleteMyRefrigerator", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultVO deleteMyRefrigerator(@RequestParam(value = "detail_id") Long detail_id) {
		System.out.println(detail_id);
		System.out.println("result delete");
		ResultVO result = new ResultVO(false, null);

		result.setResult(myRefrigeratorService.deleteMyRefrigerator(detail_id));
		result.setSuccess(true);
		System.out.println(detail_id);

		return result;
	}

}
