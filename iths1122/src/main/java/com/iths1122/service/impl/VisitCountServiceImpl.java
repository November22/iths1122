package com.iths1122.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.jpa.VisitCountRepository;
import com.iths1122.model.HsVisitCount;
import com.iths1122.service.VisitCountService;
import com.iths1122.utils.UUIDUtils;

/**
 * 用户统计服务层接口实现类
 * @author iths
 *
 */
@Service
@Transactional
public class VisitCountServiceImpl implements VisitCountService{
	
	@Autowired
	private VisitCountRepository countRepository;
	
	@Override
	public void countOrCheckVisit(String ipAddr) {
		//根据ipAddr查询用户
		HsVisitCount visitCount = countRepository.findByIpAddr(ipAddr);
		//存在，直接返回
		if(visitCount != null) return ;
		
		//不存在，插入
		//创建新的visitCount对象
		HsVisitCount newVisit = new HsVisitCount();
		//id
		String id = UUIDUtils.getId();
		//访问者的数量
		int i = countRepository.countVisitor();
		//拼接昵称编号
		String visitorNum = "visit_"+i;
		
		newVisit.setVcId(id);
		newVisit.setIp(ipAddr);
		newVisit.setVisitorNum(visitorNum);
		
		//保存访问者信息
		countRepository.save(newVisit);
	}
}
