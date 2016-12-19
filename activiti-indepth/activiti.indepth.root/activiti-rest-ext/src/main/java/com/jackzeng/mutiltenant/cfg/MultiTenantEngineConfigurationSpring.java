package com.jackzeng.mutiltenant.cfg;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.asyncexecutor.multitenant.ExecutorPerTenantAsyncExecutor;
import org.activiti.engine.impl.asyncexecutor.multitenant.SharedExecutorServiceAsyncExecutor;
import org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jackzeng.mutiltenant.DummyTenantInfoHolder;
/**
 * @author XijinZeng
 * 
 */

@Configuration
public class MultiTenantEngineConfigurationSpring {
	@Autowired
	protected DummyTenantInfoHolder tenantInfoHolder; //多租户信息存储和管理，具有简单的路由功能
	
	@Autowired
	protected MultiTenantDBCfg multiTenantDBCfg;
	
	@Autowired
	@Qualifier("processEngineConfigurationTenant")
	protected MultiSchemaMultiTenantProcessEngineConfiguration config;
	
	private ProcessEngine processEngine;
	
	private ProcessEngine setupProcessEngine(boolean schemaUpdate,boolean sharedExecutor) {
		config.setAsyncExecutorEnabled(true);
		config.setAsyncExecutorActivate(true);

		if (sharedExecutor) {
			config.setAsyncExecutor(new SharedExecutorServiceAsyncExecutor(tenantInfoHolder));
		} else {
			config.setAsyncExecutor(new ExecutorPerTenantAsyncExecutor(tenantInfoHolder));
		}

		processEngine = config.buildProcessEngine();
		
		return processEngine;
	}
	
	@Bean(name="multiTenantEngine")
	public ProcessEngine multiTenantEngine(){
		return setupProcessEngine(true,true);
	}
}
