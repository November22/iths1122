package com.iths1122.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iths1122.model.HsArticle;

/**
 * 文章表的dao
 * @author iths
 *
 */
public interface ArticleRepository extends JpaRepository<HsArticle, String>{
	
	/**
	 * 根据用户ID查找该用户所有文章
	 * @param userId
	 * @return
	 */
	@Query("select article from HsArticle article where article.userId = :userId")
	public List<HsArticle> findAllByUserId(@Param("userId")String userId);
	
	/**
	 * 
	 * @param title 文章标题
	 * @param digest 摘要
	 * @param content 内容
	 * @param updateTime 修改时间
	 * @param userId 用户ID
	 * @param articleId 文章ID
	 * @return
	 */
	@Modifying
	@Query(value = "update hs_article "
			+ "	set title = :title , digest = :digest , content = :content , update_time = :updateTime"
			+ " where "
			+ " user_id = :userId  and article_id = :articleId" , nativeQuery = true)
	public int updateArticleByArticleIdAndUserId(@Param("title")String title , @Param("digest")String digest , 
			@Param("content")String content , @Param("updateTime")Date updateTime , 
			@Param("userId")String userId ,@Param("articleId") String articleId);
	
	/**
	 * 根据用户ID和文章的ID删除文章
	 * @param articleId
	 * @param userId
	 * @return
	 */
	@Modifying
	@Query(value = "delete from hs_article where article_id = :articleId and user_id = :userId" , nativeQuery = true)
	public int deleteByArticleIdAndUserId(@Param("articleId")String articleId , @Param("userId")String userId);
}
