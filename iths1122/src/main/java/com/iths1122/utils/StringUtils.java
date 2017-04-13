package com.iths1122.utils;

public class StringUtils {
	/**
	 * 判断字符串是否为null或者“”,空返回为true，非空返回为false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
			return true;
		}
		return false;
	}
}
