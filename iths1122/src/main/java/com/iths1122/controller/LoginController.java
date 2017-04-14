package com.iths1122.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.constant.ReturnType;
import com.iths1122.model.HsUserinfo;
import com.iths1122.service.LoginService;

/**
 * 用户登录控制器
 * 简单登录，主要为了测试相册和相片
 * @author iths
 *
 */
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(String email , String password , HttpServletRequest request){
		HsUserinfo user = loginService.login(email, password);
		if(user == null) return ReturnType.ERROR;
		request.getSession().setAttribute("user", user);
		return ReturnType.SUCCESS;
	}
	
}
