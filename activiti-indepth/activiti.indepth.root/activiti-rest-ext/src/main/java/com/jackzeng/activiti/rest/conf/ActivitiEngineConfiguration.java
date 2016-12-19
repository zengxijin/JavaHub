package com.jackzeng.activiti.rest.conf;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.AbstractFormType;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.rest.form.MonthFormType;
import org.activiti.rest.form.ProcessDefinitionFormType;
import org.activiti.rest.form.UserFormType;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ActivitiEngineConfiguration {

	private final Logger log = LoggerFactory.getLogger(ActivitiEngineConfiguration.class);

	@Autowired
	protected Environment environment;

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		try {
			dataSource.setDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean(name = "processEngineFactoryBean")
	public ProcessEngineFactoryBean processEngineFactoryBean() {
		ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
		factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
		return factoryBean;
	}

	@Bean(name = "processEngine")
	public ProcessEngine processEngine() {
		// Safe to call the getObject() on the @Bean annotated
		// processEngineFactoryBean(), will be
		// the fully initialized object instanced from the factory and will NOT
		// be created more than once
		try {
			return processEngineFactoryBean().getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean(name = "processEngineConfiguration")
	public ProcessEngineConfigurationImpl processEngineConfiguration() {
		SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
		processEngineConfiguration.setDataSource(dataSource());
		processEngineConfiguration.setDatabaseType("mysql");
		processEngineConfiguration.setDatabaseSchemaUpdate(environment.getProperty("engine.schema.update"));
		processEngineConfiguration.setTransactionManager(annotationDrivenTransactionManager());
		processEngineConfiguration
				.setJobExecutorActivate(Boolean.valueOf(environment.getProperty("engine.activate.jobexecutor")));
		processEngineConfiguration
				.setAsyncExecutorEnabled(Boolean.valueOf(environment.getProperty("engine.asyncexecutor.enabled")));
		processEngineConfiguration
				.setAsyncExecutorActivate(Boolean.valueOf(environment.getProperty("engine.asyncexecutor.activate")));
		processEngineConfiguration.setHistory(environment.getProperty("engine.history.level", "full"));

		// SpringProcessEngineConfiguration processEngineConfiguration =
		// (SpringProcessEngineConfiguration) SpringContextUtil
		// .getAppContext().getBean("processEngineConfiguration");
		
		DataSourceTransactionManager transactionManager =  new DataSourceTransactionManager(); 
		transactionManager.setDataSource(dataSource());
		processEngineConfiguration.setTransactionManager(transactionManager);

		List<AbstractFormType> formTypes = new ArrayList<AbstractFormType>();
		formTypes.add(new UserFormType());
		formTypes.add(new ProcessDefinitionFormType());
		formTypes.add(new MonthFormType());
		processEngineConfiguration.setCustomFormTypes(formTypes);

		return processEngineConfiguration;
	}

	@Bean
	public RepositoryService repositoryService() {
		return processEngine().getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService() {
		return processEngine().getRuntimeService();
	}

	@Bean
	public TaskService taskService() {
		return processEngine().getTaskService();
	}

	@Bean
	public HistoryService historyService() {
		return processEngine().getHistoryService();
	}

	@Bean
	public FormService formService() {
		return processEngine().getFormService();
	}

	@Bean
	public IdentityService identityService() {
		return processEngine().getIdentityService();
	}

	@Bean
	public ManagementService managementService() {
		return processEngine().getManagementService();
	}
}
