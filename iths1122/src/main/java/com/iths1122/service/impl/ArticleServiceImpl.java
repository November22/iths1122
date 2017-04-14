package com.iths1122.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.constant.ReturnType;
import com.iths1122.jpa.ArticleRepository;
import com.iths1122.model.HsArticle;
import com.iths1122.service.ArticleService;
import com.iths1122.utils.UUIDUtils;

/**
 * 文章操作服务层实现类
 * @author iths
 *
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<HsArticle> findAllByUserId(String userId) {
		return articleRepository.findAllByUserId(userId);
	}

	@Override
	public HsArticle findOne(String articleId) {
		return articleRepository.findOne(articleId);
	}

	@Override
	public String save(HsArticle article) {
		
		//补全属性
		article.setArticleId(UUIDUtils.getId());
		article.setCreateTime(new Date());
		article.setUpdateTime(new Date());
		
		articleRepository.save(article);
		
		return ReturnType.SUCCESS;
	}

	@Override
	public String update(HsArticle article, String userId) {
		
		int i = articleRepository.updateArticleByArticleIdAndUserId(article.getTitle(), 
				article.getDigest(), 
				article.getContent(), 
				new Date(), 
				userId, 
				article.getArticleId());
		if(i == 1) return ReturnType.SUCCESS ;
		return ReturnType.ERROR;
	}

	@Override
	public String delete(String articleId, String userId) {
		int i = articleRepository.deleteByArticleIdAndUserId(articleId, userId);
		if(i == 1) return ReturnType.SUCCESS;
		return ReturnType.ERROR;
	}

}
