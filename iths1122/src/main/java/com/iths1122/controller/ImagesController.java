package com.iths1122.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.model.HsImages;
import com.iths1122.service.ImagesService;

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
	 * 查找所有相片
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsImages> all(){
		return imagesService.findAll();
	}
	
	/**
	 * 根据ID查找图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public HsImages findOne(String id){
		return imagesService.findImageById(id);
	}
	
	/**
	 * 上传一张图片
	 * @param hsImages
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsImages hsImages , String albumId){
		return imagesService.insert(hsImages , albumId);
	}
	
	/**
	 * 删除一张图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String id){
		return imagesService.delete(id);
	}
	
	/**
	 * 修改图片信息
	 * @param hsImages
	 * @return
	 */
	@RequestMapping("/update")
	public String update(HsImages hsImages ){
		return imagesService.update(hsImages);
	}
}
