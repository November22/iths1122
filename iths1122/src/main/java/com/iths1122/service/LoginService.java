package com.iths1122.service;

import com.iths1122.model.HsUserinfo;

/**
 * 登录服务层
 * @author iths
 *
 */
public interface LoginService {
	/**
	 * 根据邮箱登录
	 * @param email
	 * @param password
	 * @return
	 */
	public HsUserinfo login(String email, String password);
}
