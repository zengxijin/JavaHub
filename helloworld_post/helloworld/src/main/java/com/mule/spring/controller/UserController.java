package com.mule.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mule.spring.entity.User;  
  
/** 
 * <p>User: Zhang Kaitao 
 * <p>Date: 13-12-19 
 * <p>Version: 1.0 
 */  
@RestController  
public class UserController {  
  
	//@Autowired  
	//private  HttpServletRequest request;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)  
    public User view(@RequestParam("id") Long id) {  
        User user = new User();  
        user.setId(id);  
        user.setName("Rick");  
        return user;  
    }  
    
    @RequestMapping(value = "/hello", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    @ResponseBody
    public String hello(HttpServletRequest request,@RequestBody String message) 
    {  
    	JSONObject jsonObject = JSONObject.parseObject(message);
    	jsonObject.put("Name", "zxj" + jsonObject.getString("Id"));
    	
    	System.out.println("休眠10秒:");
    	try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String queryStr = request.getQueryString();
    	System.out.println("getQueryString:" + queryStr);
    	
    	String auth = request.getHeader("Authorization");
    	jsonObject.put("Authorization", auth);
    	System.out.println("hello->Authorization:" + auth);
        return jsonObject.toJSONString();
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String data(HttpServletRequest request,@RequestBody String message) 
    {  
    	JSONObject jsonObject = JSONObject.parseObject(message);
    	String id = jsonObject.getString("Id");
    	
    	String auth = request.getHeader("Authorization");
    	System.out.println(auth);
    	
    	String headers = "";
    	Enumeration<String> es = request.getHeaderNames();
    	while(es!=null && es.hasMoreElements()){
    		String e = es.nextElement();
    		headers += e + ":" + request.getHeader(e) + " "; 
    	}
    	System.out.println(headers);
    	
    	if(id.equals("1")){
    		jsonObject.put("Id", "1");
    		//jsonObject.put("Name", "zengxijin");
    		jsonObject.put("Authorization", auth);
    	}else{
    		jsonObject.put("Id", "2");
    		//jsonObject.put("Name", "caochangcai");
    		jsonObject.put("Authorization", auth);
    	}
        return jsonObject.toJSONString();
    }
    
    @RequestMapping(value = "/drcall", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String drcall(HttpServletRequest request,@RequestBody String message) throws UnsupportedEncodingException 
    {  
    	request.setCharacterEncoding("utf-8");
    	System.out.println(request.getCharacterEncoding());
    	System.out.println(message);
    	JSONObject jsonObject = JSONObject.parseObject(message);
    	
    	
    	String auth = request.getHeader("Authorization");
    	System.out.println("drcall Authorization:" + auth);
    	
    	
    	
    	String headers = "";
    	Enumeration<String> es = request.getHeaderNames();
    	while(es!=null && es.hasMoreElements()){
    		String e = es.nextElement();
    		headers += e + ":" + request.getHeader(e) + " "; 
    	}
    	System.out.println(headers);
    	System.out.println(jsonObject.toJSONString());
    	
        return jsonObject.toJSONString();
    }
    
    private void testJson(){
    	String message = "{\"info\":[{\"goodsId\":\"1234\",\"goodsq\":\"10\"},{\"goodsId\":\"5678\",\"goodsq\":\"20\"}]}";
    	JSONObject jsonObj = JSONObject.parseObject(message);
    }
    
}  
