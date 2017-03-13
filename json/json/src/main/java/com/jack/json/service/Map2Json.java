package com.jack.json.service;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Map2Json {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		UserInfo info = new UserInfo();
		info.setAge(25);
		info.setHasChild(true);
		info.setIncome(1234.5);
		info.setName("jack");
		info.setOccupation("公务员");
		
		map.put("org.zeng.UserInfo", info);
		map.put("abcString", "stringValue123");
		map.put("boolean", true);
		map.put("int", 1234567);
		map.put("double", 54545.23);
		
		String json = JSONObject.toJSONString(map);
		System.out.println(json);
	}

}
