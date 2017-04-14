package com.iths1122.service;

import java.util.List;

import com.iths1122.model.HsArticle;

/**
 * 文章类服务层
 * @author iths
 *
 */
public interface ArticleService {
	
	/**
	 * 根据前台传入的用户ID，查找该用户的所有ID
	 * @param userId
	 * @return
	 */
	public List<HsArticle> findAllByUserId(String userId);
	
	/**
	 * 根据文章id查文章
	 * @param articleId
	 * @return
	 */
	public HsArticle findOne(String articleId);
	
	/**
	 * 保存文章
	 * @param article
	 * @return
	 */
	public String save(HsArticle article);
	
	/**
	 * 修改文章
	 * @param article
	 * @param userId
	 * @return
	 */
	public String update(HsArticle article ,String userId);
	
	/**
	 * 删除文章
	 * @param articleId
	 * @param userId
	 * @return
	 */
	public String delete(String articleId , String userId);
}
