package com.iths1122.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author 黄森 
 * @date : 2017年2月24日 上午10:46:15
 * 加载application.properties工具类
 */
public class LoadPropertiesDataUtils {
	private static Properties mPro;
	
	static{
		mPro = new Properties();
		InputStream in = 
				LoadPropertiesDataUtils.class.getResourceAsStream("/application.properties");
		try {
			mPro.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		if(mPro == null) return null;
		return mPro.getProperty(key);
	}
}
