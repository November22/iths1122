package com.iths1122.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户ip的工具类
 * @author iths
 *
 */
public class GetIPUtils {
	//获取ip地址
    public static String getIpAddr(HttpServletRequest request) {      
           String ip = request.getHeader("x-forwarded-for");      
          if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
              ip = request.getHeader("Proxy-Client-IP");      
          }      
          if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
              ip = request.getHeader("WL-Proxy-Client-IP");      
           }      
         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
               ip = request.getRemoteAddr();      
          }      
         return ip;      
    }
}
