package com.iths1122.service;

/**
 * 用户统计服务层接口
 * @author iths
 *
 */
public interface VisitCountService {
	/**
	 * 根据ip地址检查用户是否已经被统计
	 * --没有，插入
	 * --有就不操作
	 * @param ipAddr
	 * @return
	 */
	public void countOrCheckVisit(String ipAddr);
}
