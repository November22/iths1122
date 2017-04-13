package com.iths1122.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import scala.annotation.meta.setter;

import com.iths1122.constant.ReturnType;
import com.iths1122.jpa.AlbumRepository;
import com.iths1122.jpa.ImagesRepository;
import com.iths1122.model.HsAlbum;
import com.iths1122.model.HsImages;
import com.iths1122.service.ImagesService;
import com.iths1122.utils.StringUtils;
import com.iths1122.utils.UUIDUtils;

/**
 * 
 * 相册图片的服务层
 * @author iths
 *
 */
@Service
@Transactional
public class ImagesServiceImpl implements ImagesService{
	
	@Autowired
	private ImagesRepository imagesRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public HsImages findImageById(String id) {
		return imagesRepository.findOne(id);
	}

	@Override
	public List<HsImages> findAll() {
		return imagesRepository.findAll();
	}

	@Override
	public String insert(HsImages hsImages , String albumId) {
		//补全属性
		hsImages.setImageId(UUIDUtils.getId());
		hsImages.setUploadTime(new Date());
		//album对象必须是根据相册对象的id查询出来的
		HsAlbum album = albumRepository.findOne(albumId);
		hsImages.setHsAlbum(album);
		
		imagesRepository.save(hsImages);
		return ReturnType.SUCCESS;
	}

	@Override
	public String delete(String id) {
		imagesRepository.delete(id);
		return ReturnType.SUCCESS;
	}

	@Override
	public String update(HsImages images) {
		
		if(StringUtils.isEmpty(images.getImageId())) return ReturnType.ERROR;
		
		imagesRepository.update(images.getImageName(), images.getImageUrl(), images.getImageId());
		return ReturnType.SUCCESS;
	}
}
