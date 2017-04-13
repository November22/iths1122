package com.iths1122.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * 查找对应用户的所有相册
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsAlbum> albumAll(String id){
		List<HsAlbum> albums = albumService.FindAllByUserId(id);
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
	 * ##############修改##################
	 * @param album
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsAlbum album ,String userId){
		return albumService.insert(album);
	}
	
	/**
	 * 删除一个相册，同时删除图片
	 * ##############修改##################
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String id , String userId){
		return albumService.delete(id);
	}
	
	/**
	 * 修改相册
	 * 		&albumName=&  就算前台传入的相册名为空，
	 * 只要有albumName= ，那么参数就是可以get的
	 * ##############修改##################
	 * @param album
	 * @return
	 */
	@RequestMapping("/update")
	public String update(HsAlbum album , String userId){
		String update = albumService.update(album);
		return update;
	}
}
