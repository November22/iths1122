package com.iths1122.service;

import java.util.List;

import com.iths1122.model.HsImages;

/**
 * 相册图片的服务层
 * @author iths
 *
 */
public interface ImagesService {
	
	/**
	 * 根据id查找ID
	 * @param id
	 * @return
	 */
	public HsImages findImageById(String id);
	
	/**
	 * 查找所有图片
	 * 这个在添加权限控制之后，在使用
	 * @param albumId 
	 * @return
	 */
	public List<HsImages> findAll(String albumId);
	
	/**
	 * 插入图片
	 * @param hsImages
	 * @param userId 
	 * @return
	 */
	public String insert(HsImages hsImages , String albumId, String userId);
	
	/**
	 * 删除图片
	 * @param id
	 * @param userId 
	 * @param albumId 
	 * @return
	 */
	public String delete(String id, String albumId, String userId);
	
	/**
	 * 修改图片
	 * @param images
	 * @param userId 
	 * @param albumId 
	 * @return
	 */
	public String update(HsImages images, String albumId, String userId);
}
