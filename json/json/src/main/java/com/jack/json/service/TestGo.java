package com.jack.json.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestGo {
	public static void main(String[] args) {
		// Map map =
		// JsonUtils.jsonToObjbect("{\"content\":[{\"state\":\"02\",\"billno\":\"161114002902010026\",\"note\":\"直投借款合同已放款，不允许重复放款\"}],\"result\":\"0000\"}",
		// HashMap.class);
		// List<Map<String, String>> resList =
		// JsonUtils.jsonToObjbect(MapUtils.getString(map, "content"),
		// ArrayList.class);
		// System.out.println("####" + MapUtils.getString(resList.get(0),
		// "billno"));

		String testStr = "{\"content\":[{\"state\":\"02\",\"billno\":\"161114002902010026\",\"note\":\"直投借款合同已放款，不允许重复放款\"}],\"result\":\"0000\"}";
		JSONObject obj = JSONObject.parseObject(testStr);

		JSONArray ary = obj.getJSONArray("content");

		if (!ary.isEmpty()) {
			System.out.println(ary.getJSONObject(0).getString("billno"));
		}
				
		Gson gson = new Gson();
		Map map = gson.fromJson(testStr, HashMap.class);
		System.out.println(map);
		
		//这个写法有问题转换会有问题
		List<Map> wrong = gson.fromJson(MapUtils.getString(map, "content"), ArrayList.class);
		System.out.println(wrong);
		
		//下面的写法OK
		List<Map> right = gson.fromJson(MapUtils.getString(map, "content"), new TypeToken<List<Map<String, String>>>() { }.getType());
		System.out.println(right);
		
//		if (StringUtils.equals(MapUtils.getString(map, "result"), "0000")) {
//			List<Map<String,String>> resList = gson.fromJson(MapUtils.getString(map, "content"), new TypeToken<List<Map<String, String>>>() { }.getType());//转换会有问题
//			System.out.println(resList);
//			String billno = MapUtils.getString(resList.get(0), "billno");
//			System.out.println(MapUtils.getLongValue(resList.get(0), "billno"));
//			System.out.println(billno); 
//		}
		
		//new Gson().fromJson(str, new TypeToken<Map<String, String>>() { }.getType())
	}

	
}
