package com.hustar.recipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hustar.recipe.service.UserService;
import com.hustar.recipe.vo.MyRefrigeratorVO;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("user/")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	UserService userService;
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "userInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public ResultVO Login(@RequestParam(value="id") String id) {
		
		System.out.println("userList");
		ResultVO result = new ResultVO(false, null);
			result.setResult(userService.getUser(id));
			result.setSuccess(true);
			System.out.println(result);
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
	public int Login(@RequestParam(value="id") String id, 
						@RequestParam(value="password") String password) {
		
		System.out.println("=================");
		System.out.println(id + "  " + password);
		System.out.println("=================");
		
		int tmp = userService.checkLogin(id, password);
		
		  if(tmp == 1){
	            System.out.println("없는 아이디");
	            return 1;
	        }else {
	            if(tmp == 2){
	                System.out.println("비밀번호가 일치하지 않습니다.");
	                return 2;
	            }
	            ResponseEntity response = null;
	            try {
	                System.out.println("로그인 시도중");
	                response = new ResponseEntity<String>("success", HttpStatus.OK);
	                System.out.println("로그인완료");
	                return 0;
	            } catch (Exception e) {
	                response = new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	                return 3;
	            }
	        }
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "registUser", method = { RequestMethod.POST, RequestMethod.GET })
	public int registUser(@RequestParam(value = "id") String id,
								@RequestParam(value = "password") String password,
								@RequestParam(value = "name") String name) {

		System.out.println("result regist User");
		Boolean result = false;
		
		result = userService.registUser(id, password, name);
		
		System.out.println(result);
		
		if(result == true) {
			return 1;
		}
		else {
			return 0;
		}

		
	}
	
	
	


}
