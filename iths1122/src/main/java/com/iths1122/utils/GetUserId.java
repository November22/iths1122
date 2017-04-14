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
		HsUserinfo user = (HsUserinfo)request.getSession().getAttribute("user");
		if(user != null && !StringUtils.isEmpty(user.getUserId())){
			return user.getUserId();
		} else {
			return ReturnType.ERROR;
		}
	}
}
