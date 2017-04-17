package com.iths1122.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iths1122.jpa.AlbumRepository;
import com.iths1122.jpa.ArticleRepository;
import com.iths1122.jpa.LeaveWordRepository;
import com.iths1122.jpa.ShareRepository;
import com.iths1122.model.HsAlbum;
import com.iths1122.model.HsArticle;
import com.iths1122.model.HsDictionary;
import com.iths1122.model.HsLeaveWord;
import com.iths1122.model.HsShare;
import com.iths1122.service.LeaveWordService;

/**
 * 留言服务层接口实现类
 * @author iths
 *
 */
@Service
@Transactional
public class LeaveWordServiceImpl implements LeaveWordService{
	
	@Autowired
	private LeaveWordRepository leaveWordRepository;
	
	@Autowired
	private ArticleRepository  articleRepository;
	
	@Autowired
	private ShareRepository shareRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public List<HsLeaveWord> findAllByUserId(String userId) {
		return leaveWordRepository.findAllByUserId(userId);
	}
	
	/**
	 * 对于Dictionary的ID
	 * 3-代表主页
	 * 4-代表文章
	 * 5-代表分享
	 * 6-代表相册
	 */
	@Override
	public Map<String, Object> getLeaveWordToMap(String leaveWordId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//根据留言的ID，查找出留言对象
		HsLeaveWord leaveWord = leaveWordRepository.findOne(leaveWordId);
		
		Integer dictionaryId = leaveWord.getHsDictionary().getDictionaryId();
		if(dictionaryId == 3){ //留言于主页,直接返回
			map.put("address", "主页地址");
			
		} else if (dictionaryId == 4) { //留言于文章
			map.put("address", "个人文章查看的详细地址");
			//根据belong_id查找文章的详细信息
			String belongId = leaveWord.getBelongId();
			HsArticle article = articleRepository.findOne(belongId);
			map.put("key", "article");
			map.put("Object", article);
		} else if (dictionaryId == 5) { //留言在分享
			map.put("address", "分享的详细地址");
			//根据belong_id查找文章的详细信息
			String belongId = leaveWord.getBelongId();
			HsShare share = shareRepository.findOne(belongId);
			map.put("key", "share");
			map.put("Object", share);
		} else if (dictionaryId == 6) { //留言于相册
			map.put("address", "相册的详细地址");
			//根据belong_id查找文章的详细信息
			String belongId = leaveWord.getBelongId();
			HsAlbum album = albumRepository.findOne(belongId);
			map.put("key", "album");
			map.put("Object", album);
		}
		return map;
	}
}
