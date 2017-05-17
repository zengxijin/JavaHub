package com.mule.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class ExtChannel {
	
	@RequestMapping(value = "/extchannel/v1/quark/loanstatus", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    @ResponseBody
    public String loanstatus(HttpServletRequest request,@RequestBody String message) 
    {  
		String tocken = request.getHeader("Authorization");
		System.out.println(tocken);
		
		if (StringUtils.isNoneBlank(tocken)) {
			if (authTocken(tocken)) {
				JSONObject jsonObject = JSONObject.parseObject(message);
				String sign = jsonObject.getString("sign");
				//todo:业务逻辑处理
				return "{\"code\":200,\"msg\":\"OK\"}";
			} else {
				// 认证失败：
				return "{\"code\":300,\"msg\":\"tocken invalid\"}";
			}
		} else {
			return "{\"code\":500,\"msg\":\"tocken is empty\"}";
		}
    }
	
	@RequestMapping(value = "/v1/quark/auth/tocken", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    @ResponseBody
    public String tocken(HttpServletRequest request,@RequestBody String message) 
    {  
		String assertion = request.getHeader("Assertion");
		System.out.println(assertion);

		if (StringUtils.isNoneBlank(assertion)) {
			// todo:业务逻辑处理，去产生tocken
			return "{\"code\":200,\"msg\":\"OK\"}";

		} else {
			return "{\"code\":500,\"msg\":\"tocken is empty\"}";
		}
    }
	
	public static boolean authTocken(String tocken){
		//todo:授权认证
		return true;
	}
	
	
}
