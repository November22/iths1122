package com.iths1122.utils;

import javax.servlet.http.HttpServletRequest;

import com.iths1122.constant.ReturnType;
import com.iths1122.model.HsUserinfo;

/**
 * 从session中获取user的ID
 * 
 * @author iths
 *
 */
public class GetUserId {
	public static String getUserId(HttpServletRequest request){
		//从session中获取用户对象
		HsUserinfo user = (HsUserinfo)request.getSession().getAttribute("user");
		//user对象在session中是否存在，取出对象ID
		if(user != null && !StringUtils.isEmpty(user.getUserId())){
			return user.getUserId();
		} else {
			return ReturnType.ERROR;
		}
	}
}
