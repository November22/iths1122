package com.iths1122.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.constant.ReturnType;
import com.iths1122.jpa.AlbumRepository;
import com.iths1122.model.HsAlbum;
import com.iths1122.service.AlbumService;
import com.iths1122.utils.StringUtils;
import com.iths1122.utils.UUIDUtils;

/**
 * 相册操作的实现类
 * @author iths
 *
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public List<HsAlbum> FindAll() {
		return albumRepository.findAll();
	}

	@Override
	public HsAlbum FindAlbumById(String id) {
		return albumRepository.findOne(id);
	}

	@Override
	public String insert(HsAlbum album) {
		String id = UUIDUtils.getId();
		//补全属性
		album.setCreateTime(new Date());
		album.setAlbumId(id);
		album.setVisitCount(0);
		
		//////目前用户ID都设置为u1//////
		album.setUserId("u1");
		albumRepository.save(album);
		
		
		return ReturnType.SUCCESS;
	}

	@Override
	public String delete(String id) {
		albumRepository.delete(id);
		return ReturnType.SUCCESS;
	}

	@Override
	public String update(HsAlbum album) {
		//一定要禁止id不存在的情况
		if(StringUtils.isEmpty(album.getAlbumId())) return ReturnType.ERROR;
		
		albumRepository.update(album.getAlbumName() , album.getDescription(),album.getAlbumId());
		return ReturnType.SUCCESS;
	}
	
}
