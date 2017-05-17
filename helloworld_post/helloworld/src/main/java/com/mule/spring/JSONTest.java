package com.mule.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mule.spring.entity.AuditStatus;
import com.mule.spring.entity.TockenInfo;


public class JSONTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		//JSONObject obj = new JSONObject();
		//String ss = "1200.00";
		//System.out.println(StringUtils.isBlank(ss));
		//JSONTest t = new JSONTest();
		//t.testJosn();

		//String str = "132-a34324";

		//System.out.println(judgeContainsStr(str));
		
		//Map<String,Map<String,String>> mutilMap = new HashMap<String,Map<String,String>>();
		
		
//		HashMap<String,String> m1 = new HashMap<String,String>(); 
//		m1.put("token", "ZGE0NDI5MTE5ZjBlNGQ3OGFhNmJjMjRhMTkzNzFkOGM");
//		m1.put("expires_second", "1200");
//		
//		HashMap<String,String> m2 = new HashMap<String,String>(); 
//		m2.put("token", "AGE0NDI5MTE5ZjBlNGQ3OGFhNmJjMjRhMTkzNzFkOGM");
//		m2.put("expires_second", "7200");
//		HashMap[] map = new HashMap[]{m1,m2};
//		map[0] = m1;
//		map[1] = m2;
//		
//		TockenInfo tocken = new TockenInfo();
//		tocken.code = 200;
//		tocken.message="OK";
//		//tocken.data = map;
//		
//		System.out.println(JSONObject.toJSONString(tocken));
		
		Map<String,String> map = new TreeMap<String,String>();
		map.put("AB", "11");
		map.put("CB", "11");
		map.put("BT", "11");
		
		System.out.println(map);
		
	}
	
	public static Map<String,String> getMap(String key,String val){
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", key);
		map.put("val", val);
		return map;
	}
	
	public static boolean judgeContainsStr(String cardNum) {  
        String regex=".*[a-zA-Z]+.*";  
        Matcher m=Pattern.compile(regex).matcher(cardNum); 
        return m.matches();  
    }
	
	public void testJosn(){
		String json = readFileByLines("D:\\AMS\\点融四期\\ams_json_dr4.json");
		JSONObject obj = JSONObject.parseObject(json);
		JSONArray array = obj.getJSONObject("loans").getJSONArray("contact");
		JSONObject nodeValid = null;
		for(int i=0;i<array.size();i++){
			JSONObject node = (JSONObject)array.get(i);
			if("relationshipRelMat".equals(node.getString("CONTACT_RELATION"))){
				nodeValid = node;
				break;
			}
		}
		if(nodeValid != null){
			array.clear();
			array.add(nodeValid);
		}
		System.out.println(obj.toJSONString());
	}
	
	public void test() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpComponentsClientHttpRequestFactory rf =
        	    (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
        	rf.setReadTimeout(1 * 1000);
        	rf.setConnectTimeout(1 * 1000);
		
		
        Field field1 = rf.getClass().getDeclaredField("requestConfig");
        field1.setAccessible(true);
        RequestConfig cfg = (RequestConfig)field1.get(rf);
        
        System.out.println("hahaha:" + cfg.getSocketTimeout());
	}
	
	public static String readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				buffer.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return buffer.toString();
	}
}
