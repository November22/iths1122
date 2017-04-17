package com.iths1122.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.service.VisitCountService;
import com.iths1122.utils.GetIPUtils;

/**
 * 
 * 访问者访问主页
 * @author iths
 *
 */
@RestController
public class Index {
	
	@Autowired
	private VisitCountService countService;
	
	/**
	 * 用户访问网站主页
	 * --显示主页信息
	 * --获取用户IP，统计数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request){
		//获取访问者的IP
		String ipAddr = GetIPUtils.getIpAddr(request);
		//统计或者检查用户是否已经访问
		countService.countOrCheckVisit(ipAddr);
		return "index";
	}
}

