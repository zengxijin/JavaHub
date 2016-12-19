package com.jackzeng.bpm.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jackzeng.bpm.auth.response.CheckUserResponse;
import com.jackzeng.bpm.auth.service.AuthService;
import com.jackzeng.bpm.auth.service.impl.AuthServiceImpl;
import com.jackzeng.util.SpringContextHolder;
/**
 * @author XijinZeng
 */

@RestController
public class AuthServiceController {
	
	protected AuthService authService =  new AuthServiceImpl();
	
	@RequestMapping(value="/crc/identity/users/checkUser", method = RequestMethod.POST, produces = "application/json")
	public CheckUserResponse checkUser(HttpServletRequest request,@RequestBody String message){
		CheckUserResponse res = new CheckUserResponse();
		
		JSONObject obj = JSONObject.parseObject(message);
		if( authService.checkPassword(obj.getString("user"), obj.getString("pwd")) == true){
			res.setStatus("200");
			res.setCode("2000");
			res.setMsg("OK");
		}else{
			res.setStatus("200");
			res.setCode("40001");
			res.setMsg("auth failed");
		}
		
		return res;
	}
}
