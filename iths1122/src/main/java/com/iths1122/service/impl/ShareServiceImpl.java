package com.iths1122.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.constant.ReturnType;
import com.iths1122.jpa.DictonaryRepository;
import com.iths1122.jpa.ShareRepository;
import com.iths1122.model.HsDictionary;
import com.iths1122.model.HsShare;
import com.iths1122.service.ShareService;
import com.iths1122.utils.UUIDUtils;

/**
 * 分享类的服务层实现
 * @author iths
 *
 */
@Service
@Transactional
public class ShareServiceImpl implements ShareService{

	@Autowired
	private ShareRepository shareRepository;
	
	@Autowired
	private DictonaryRepository dictonaryRepository;
	
	@Override
	public List<HsShare> findAllByUserId(String userId) {
		return shareRepository.findAllByUserId(userId);
	}

	@Override
	public HsShare findOne(String shareId) {
		return shareRepository.findOne(shareId);
	}

	@Override
	public String insert(HsShare hsShare , int dictionaryId) {
		
		//补全属性
		//字典表-分享类型
		HsDictionary dictionary = dictonaryRepository.findOne(dictionaryId);
		hsShare.setHsDictionary(dictionary);
		//创建时间
		hsShare.setCreateTime(new Date());
		//分享的ID
		String id = UUIDUtils.getId();
		hsShare.setShareId(id);
		
		shareRepository.save(hsShare);
		
		return ReturnType.SUCCESS;
	}

	@Override
	public String delete(String shareId, String userId) {
		int i = shareRepository.deleteByShareIdAndUserId(shareId, userId);
		if( i == 1) return ReturnType.SUCCESS;
		return ReturnType.ERROR;
	}

}
