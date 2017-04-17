package com.iths1122.controller;

import org.json.JSONObject;
import org.junit.Test;

import com.iths1122.model.HsLeaveWord;

public class TestAA {
	
	@Test
	public void test(){
		HsLeaveWord lw = new HsLeaveWord();
		lw.setContent("asdfasdfasdfasd");
		lw.setBelongId("12312");
		lw.setUserId("asdfasdf");
		Object obj = lw;
		JSONObject json = new JSONObject(obj);
		
		System.out.println(json.toString());
	}
}
