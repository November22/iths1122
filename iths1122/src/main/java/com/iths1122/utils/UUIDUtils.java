package com.iths1122.utils;

import java.util.UUID;

/**
 * id工具生成类
 * @author iths
 *
 */
public class UUIDUtils {
	/**
	 * 使用UUID生成用表的主键id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
