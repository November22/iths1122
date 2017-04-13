package com.iths1122.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.jpa.UserInfoRepository;
import com.iths1122.model.HsUserinfo;

@RestController
public class Index {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/all")
	public List<HsUserinfo> all(){
		List<HsUserinfo> list = userInfoRepository.findAll();
		return list;
	}
	
	@RequestMapping("/insert")
	public String insert(HsUserinfo userinfo){
		userInfoRepository.save(userinfo);
		return "success";
	}
}
