package com.iths1122.service;

import java.util.List;
import java.util.Map;

import com.iths1122.model.HsLeaveWord;

/**
 * 留言服务层接口
 * @author iths
 *
 */
public interface LeaveWordService {
	
	/**
	 * 根据用户id，查看所有留言
	 * @param userId
	 * @return
	 */
	public List<HsLeaveWord> findAllByUserId(String userId);
	
	//根据留言跳转到，留言所在的地址；需要知道留言的地址，留言的对象
	/**
	 * 根据留言的ID，查找到留言的所在地址--belongId
	 * 返回查找出的 相册/文章/分享/主页，然后判断需要跳转的地址
	 * 返回数据存放两个map
	 * 第一个存放跳转地址 key值固定为 address
	 * 第二个存放 将数据放在model中时，key值 如 model.AddAttribute("就是这个值","第三个个值")
	 * 第三个存放返回 de 对象的类型
	 * 
	 * @param leaveWordId
	 * @return
	 */
	public Map<String , Object> getLeaveWordToMap(String leaveWordId);
	
}
