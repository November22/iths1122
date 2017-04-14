package com.iths1122.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.model.HsImages;
import com.iths1122.service.ImagesService;
import com.iths1122.utils.GetUserId;

/**
 * 图片操作
 * @author iths
 *
 */
@RestController
@RequestMapping("/images")
public class ImagesController {
	
	@Autowired
	private ImagesService imagesService;
	
	/**
	 * 查找对应相册的所有相片
	 * ##############修改##################
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsImages> all(String albumId){
		return imagesService.findAll(albumId);
	}
	
	/**
	 * 根据ID查找图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public HsImages findOne(String imageId){
		return imagesService.findImageById(imageId);
	}
	
	/**
	 * 上传一张图片
	 * @param hsImages
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsImages hsImages , String albumId , HttpServletRequest request){
		
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		return imagesService.insert(hsImages , albumId ,result);
	}
	
	/**
	 * 删除一张图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String imageId , String albumId , HttpServletRequest request){
		
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		return imagesService.delete(imageId ,albumId ,result);
	}
	
	/**
	 * 修改图片信息
	 * ##############修改##################
	 * @param hsImages
	 * @return
	 */
	@RequestMapping("/update")
	public String updateImageName(HsImages hsImages ,String albumId , HttpServletRequest request ){
		
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return result;
		
		return imagesService.update(hsImages , albumId, result);
	}
}
