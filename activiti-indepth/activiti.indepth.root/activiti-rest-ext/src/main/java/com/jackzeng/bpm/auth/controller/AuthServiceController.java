package com.jackzeng.bpm.auth.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.ldap.LDAPConfigurator;
import org.activiti.ldap.LDAPUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jackzeng.bpm.auth.ldap.LDAPQueryConfig;
import com.jackzeng.bpm.auth.request.CheckUserRequest;
import com.jackzeng.bpm.auth.response.CheckUserResponse;
import com.jackzeng.bpm.auth.service.AuthService;
import com.jackzeng.bpm.auth.service.impl.AuthServiceImpl;
import com.jackzeng.entity.CRCResponse;
import com.jackzeng.util.SpringContextHolder;
/**
 * @author XijinZeng
 */


@RestController
public class AuthServiceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceController.class);
	
	@Autowired
	protected LDAPConfigurator ldapConfigurator;
	
	@Autowired
	protected LDAPQueryConfig ldapQueryConfig;
	
	@RequestMapping(value = "/crc/identity/users/checkUser", method = RequestMethod.POST, produces = "application/json")
	public CheckUserResponse checkUser(HttpServletRequest request, @RequestBody String message) {
		CheckUserResponse res = new CheckUserResponse();
		try {
			CheckUserRequest  req   = JSONObject.parseObject(message, CheckUserRequest.class);
			AuthService authService = new AuthServiceImpl(new LDAPUserManager(ldapConfigurator));
			String queryUserId      = MessageFormat.format(ldapQueryConfig.getUserIdQuery(), req.getUser());
			if (authService.checkPassword(queryUserId, req.getPassword()) == true) { 
				//Auth Success
				return res;
			} else { 
				//Auth FAIL
				res.setCode(CRCResponse.CODE.UNAUTHORIZED);
				res.setMsg("auth failed");
			}
		} catch (Exception e) {
			res.setCode(CRCResponse.CODE.ERROR);
			res.setMsg("check user internal error");
			LOGGER.error("checkUser internal error",e);
		}

		return res;
	}
}
