package com.iths1122.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iths1122.model.HsLeaveWord;
import com.iths1122.service.LeaveWordService;
import com.iths1122.utils.GetUserId;

/**
 * 留言的控制器
 * 
 * ###插入新的留言还没有
 * ###删除留言还没有
 * 
 * @author iths
 *
 */
@RestController
@RequestMapping("/leaveword")
public class LeaveWordController {
	
	@Autowired
	private LeaveWordService leaveWordService;
	
	
	/**
	 * 查找对应用户的所有留言
	 * 必须是登录之后才允许
	 * @return
	 */
	@RequestMapping("/all")
	public List<HsLeaveWord> all(HttpServletRequest request){
		String result = GetUserId.getUserId(request);
		if(result.equals("error")) return new ArrayList<HsLeaveWord>();
		
		return leaveWordService.findAllByUserId(result);
	}
	
	/**
	 * 根据留言的ID，跳转到留言的地方
	 * @param leaveWordId
	 */
	@RequestMapping("/toLeaveWordAddr")
	public Object toLeaveWordAddr(String leaveWordId){
		Map<String, Object> map = leaveWordService.getLeaveWordToMap(leaveWordId);
		String addr = (String) map.get("address");
		System.err.println("跳转的地址" + addr);
		if(map.size() == 1) return null; //如果只有一个数据，那么就是跳转至主页
		
		String key = (String) map.get("key");
		System.err.println("存储在model中的key值"+key);
		
		Object object = map.get("Object");
		return object;
	}
}

