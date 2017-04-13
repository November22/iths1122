package com.iths1122.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.constant.ReturnType;
import com.iths1122.model.HsAlbum;
import com.iths1122.service.AlbumService;


/**
 * 
 * @author iths
 * 相册的控制类
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	/**
	 * 查找所有相册
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsAlbum> albumAll(){
		List<HsAlbum> albums = albumService.FindAll();
		return albums;
	}
	
	/**
	 * 根据id查询相册
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public HsAlbum album(String id){
		HsAlbum album = albumService.FindAlbumById(id);
		return album;
	}
	
	/**
	 * 插入一个相册
	 * @param album
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsAlbum album){
		return albumService.insert(album);
	}
	
	/**
	 * 删除一个相册，同时删除图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String id){
		return albumService.delete(id);
	}
}
