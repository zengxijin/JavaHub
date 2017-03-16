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
		
		map.put(info.getClass().getCanonicalName(), info);
		map.put("abcString", "stringValue123");
		map.put("boolean", true);
		map.put("int", 1234567);
		map.put("double", 54545.23);
		
		String json = JSONObject.toJSONString(map);
		System.out.println(json);
		
		JSONObject obj = JSONObject.parseObject(json);
		String userInfo = obj.getString(UserInfo.class.getCanonicalName());
		System.out.println(userInfo);
		
		try {
			Class clz = Class.forName(UserInfo.class.getCanonicalName());
			UserInfo info2 = JSONObject.toJavaObject(obj.getJSONObject(UserInfo.class.getCanonicalName()), clz);
			System.out.println(info2.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
