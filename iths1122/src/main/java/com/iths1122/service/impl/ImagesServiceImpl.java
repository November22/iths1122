package com.iths1122.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<HsImages> findAll(String albumId) {
		return imagesRepository.findAllByAlbumId(albumId);
	}

	@Override
	public String insert(HsImages hsImages , String albumId , String userId) {
		//补全属性
		hsImages.setImageId(UUIDUtils.getId());
		hsImages.setUploadTime(new Date());
		//album对象必须是根据相册对象的id和用户的ID查询出来的
		HsAlbum album = albumRepository.findByAlbumIdAndUesrId(albumId, userId);
		//查出对象为空，则不能上传图片
		if(album == null) return ReturnType.ERROR;
		
		hsImages.setHsAlbum(album);
		
		imagesRepository.save(hsImages);
		return ReturnType.SUCCESS;
	}

	@Override
	public String delete(String imgId , String albumId , String userId) {
		HsAlbum album = albumRepository.findByAlbumIdAndUesrId(albumId, userId);
		if(album == null) return ReturnType.ERROR;
		
		imagesRepository.deleteByImageIdAndAlbumId(imgId , albumId);
		return ReturnType.SUCCESS;
	}
	

	/**
	 * 只能修改图片的名称
	 */
	@Override
	public String update(HsImages images , String albumId , String userId) {
		
		if(StringUtils.isEmpty(images.getImageId())) return ReturnType.ERROR;
		
		HsAlbum album = albumRepository.findByAlbumIdAndUesrId(albumId, userId);
		if(album == null) return ReturnType.ERROR;
		
		//修改图片名称
		imagesRepository.updateImagsNameByImageIdAndAlbumId(images.getImageName(), images.getImageId(), albumId);
		
		return ReturnType.SUCCESS;
	}
}
