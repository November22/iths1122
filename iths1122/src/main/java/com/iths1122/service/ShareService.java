package com.iths1122.service;

import java.util.List;

import com.iths1122.model.HsShare;

/**
 * 用户分享服务层接口
 * @author iths
 *
 */
public interface ShareService {
	
	/**
	 * 查找对应用户的所有分享内容
	 * @param userId
	 * @return
	 */
	public List<HsShare> findAllByUserId(String userId);
	
	/**
	 * 查找一条分享
	 * @param shareId
	 * @return
	 */
	public HsShare findOne(String shareId);
	
	/**
	 * 插入一条数据
	 * @param hsShare
	 * @return
	 */
	public String insert(HsShare hsShare , int dictionaryId);
	
	/**
	 * 根据用户ID和分享ID删除一条分享
	 * @param shareId
	 * @param userId
	 * @return
	 */
	public String delete(String shareId, String userId);
}
