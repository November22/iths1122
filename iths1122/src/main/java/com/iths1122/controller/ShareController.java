package com.iths1122.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.constant.ReturnType;
import com.iths1122.model.HsShare;
import com.iths1122.service.ShareService;
import com.iths1122.utils.GetUserId;

/**
 * 分享控制器
 * @author iths
 *
 */
@RestController
@RequestMapping("/share")
public class ShareController {
	
	@Autowired
	private ShareService shareService;
	
	//查增改删  - 分享不允许修改
	/**
	 * 根据用户的ID获取所有
	 * @return
	 */
	@RequestMapping("all")
	public List<HsShare> findAll(String userId){
		return shareService.findAllByUserId(userId);
	}
	
	/**
	 * 查找对应shareId的分享
	 * @param shareId
	 * @return
	 */
	@RequestMapping("findOne")
	public HsShare findOne(String shareId){
		return shareService.findOne(shareId);
	}
	
	/**
	 * 插入一条数据
	 * @param hsShare
	 * @param request
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsShare hsShare ,int dictionaryId,HttpServletRequest request){
		String userId = GetUserId.getUserId(request);
		if("error".equals(userId)) return ReturnType.ERROR;
		
		hsShare.setUserId(userId);
		
		return shareService.insert(hsShare, dictionaryId);
	}
	
	/**
	 * 删除分享
	 * @param shareId
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String shareId ,HttpServletRequest request){
		String userId = GetUserId.getUserId(request);
		if("error".equals(userId)) return ReturnType.ERROR;
		return shareService.delete(shareId, userId);
	}
}
