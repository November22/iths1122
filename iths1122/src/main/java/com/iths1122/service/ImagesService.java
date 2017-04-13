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
	 * @return
	 */
	public List<HsImages> findAll();
	
	/**
	 * 插入图片
	 * @param hsImages
	 * @return
	 */
	public String insert(HsImages hsImages , String albumId);
	
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	public String delete(String id);
	
	/**
	 * 修改图片
	 * @param images
	 * @return
	 */
	public String update(HsImages images);
}
