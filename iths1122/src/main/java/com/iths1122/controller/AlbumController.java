package com.iths1122.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.model.HsAlbum;
import com.iths1122.service.AlbumService;
import com.iths1122.utils.GetUserId;

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
	public List<HsAlbum> albumAll(HttpServletRequest request){
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return new ArrayList<HsAlbum>();
		List<HsAlbum> albums = albumService.FindAllByUserId(result);
		return albums;
	}
	
	/**
	 * 根据id查询相册
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public HsAlbum album(String albumId){
		HsAlbum album = albumService.FindAlbumById(albumId);
		return album;
	}
	
	/**
	 * 插入一个相册，在传入参数的时候，会包含用户的userid，----从session中获取
	 * 这里user表没有和其他所有表的外键关键
	 * 
	 * @param album
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsAlbum album ,HttpServletRequest request){
		//userId的获取，这里可以抽取为方法
		
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		album.setUserId(result);
		return albumService.insert(album);
	}
	
	/**
	 * 删除一个相册，同时删除图片
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String albumId , HttpServletRequest request){
		
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		return albumService.delete(albumId ,result);
	}
	
	/**
	 * 修改相册
	 * 		&albumName=&  就算前台传入的相册名为空，
	 * 只要有albumName= ，那么参数就是可以get的
	 * @param album
	 * @return
	 */
	@RequestMapping("/update")
	public String update(HsAlbum album ,HttpServletRequest request){
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		album.setUserId(result);
		return albumService.update(album);
	}
}
