package com.iths1122.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.constant.ReturnType;
import com.iths1122.model.HsArticle;
import com.iths1122.service.ArticleService;
import com.iths1122.utils.GetUserId;
import com.iths1122.utils.StringUtils;

/**
 * 文章操作控制器类
 * @author iths
 *
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	//文章的查增改删
	/**
	 * 查找该用户的所有文章
	 * 这个显示的时候不会把内容全面展示给用户看
	 * @param userId
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsArticle> all(String userId){
		
		if(StringUtils.isEmpty(userId)) return new ArrayList<HsArticle>();
		
		return articleService.findAllByUserId(userId);
	}
	
	/**
	 * 根据文章ID查文章
	 * @param articleId
	 * @return
	 */
	@RequestMapping("/findOne")
	public HsArticle findOne(String articleId){
		if(StringUtils.isEmpty(articleId)) return null;
		return articleService.findOne(articleId);
	}
	
	/**
	 * 插入文章
	 * @param article
	 * @param request
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(HsArticle article , HttpServletRequest request){
		//session中获取用户的对象
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return ReturnType.ERROR;
		
		article.setUserId(result);
		return articleService.save(article);
	}
	
	/**
	 * 修改文章
	 * @param article
	 * @param request
	 * @return
	 */
	@RequestMapping("/update")
	public String update(HsArticle article , HttpServletRequest request){
		//session中获取用户的对象
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return ReturnType.ERROR;
		
		return articleService.update(article, result);
	}
	
	/**
	 * 根据文章ID删除文章
	 * @param atricleId
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String articleId ,HttpServletRequest request){
		//session中获取用户的对象
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return ReturnType.ERROR;
		
		return articleService.delete(articleId, result);
	}
}
