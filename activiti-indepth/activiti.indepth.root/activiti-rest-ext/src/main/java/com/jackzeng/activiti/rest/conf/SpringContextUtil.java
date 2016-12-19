package com.jackzeng.activiti.rest.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {
	private static final Logger log = LoggerFactory.getLogger(SpringContextUtil.class);
	private static ApplicationContext appContext;
	
	public synchronized static void loadActCfg(){
		//配置activiti引擎
		appContext = new ClassPathXmlApplicationContext("classpath:activiti-context-cfg.xml");
		log.debug("activiti-context-cfg.xml 配置加载完成");
	}
	
	public synchronized static ApplicationContext getAppContext(){
		if(appContext == null){
			loadActCfg();
		}
		return appContext;
	}
	
}
