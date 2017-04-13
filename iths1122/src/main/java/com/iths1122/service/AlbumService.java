package com.iths1122.service;

import java.util.List;

import com.iths1122.model.HsAlbum;

/**
 * 
 * @author iths
 *
 */
public interface AlbumService {
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<HsAlbum> FindAllByUserId(String userId);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public HsAlbum FindAlbumById(String id);
	
	/**
	 * 插入相册对象
	 * @param album
	 * @return
	 */
	public String insert(HsAlbum album);
	
	/**
	 * 删除一个相册
	 * @param id
	 * @return
	 */
	public String delete(String id);
	
	/**
	 * 修改相册
	 * @param album
	 * @return
	 */
	public String update(HsAlbum album);
}
