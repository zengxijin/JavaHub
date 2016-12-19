package com.jackzeng.bpm.auth.service.impl;

import java.text.MessageFormat;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.ldap.LDAPConfigurator;
import org.activiti.ldap.LDAPUserManager;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.jackzeng.activiti.rest.conf.SpringContextUtil;
import com.jackzeng.bpm.auth.ldap.LDAPQueryConfig;
import com.jackzeng.bpm.auth.service.AuthService;

/**
 * @author XijinZeng
 * 2016-12-05 10:26:36
 * based on activiti LDAP implements
 */

public class AuthServiceImpl implements AuthService {

	public boolean checkPassword(String userId, String pwd) {
		ApplicationContext ac = SpringContextUtil.getAppContext(); 
		//SpringProcessEngineConfiguration cfg = (SpringProcessEngineConfiguration)ac.getBean("processEngineConfiguration");
		//ProcessEngine engine = cfg.buildProcessEngine();
		
		LDAPConfigurator ldapCfg     = (LDAPConfigurator)ac.getBean("ldapConfigurator");
		LDAPUserManager  userManager = new LDAPUserManager(ldapCfg);
		
		LDAPQueryConfig queryCfg = (LDAPQueryConfig)ac.getBean("ldapQueryConfig");
		String queryUserId = MessageFormat.format(queryCfg.getUserIdQuery(), userId);
		
		return userManager.checkPassword(queryUserId, pwd);
	}

	public List<Object> findByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> findByGroupId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
