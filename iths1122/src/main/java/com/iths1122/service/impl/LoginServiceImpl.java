package com.iths1122.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.jpa.UserInfoRepository;
import com.iths1122.model.HsUserinfo;
import com.iths1122.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public HsUserinfo login(String email, String password) {
		HsUserinfo userinfo = userInfoRepository.findByUsernameAndPassword(email , password);
		return userinfo;
	}
}
