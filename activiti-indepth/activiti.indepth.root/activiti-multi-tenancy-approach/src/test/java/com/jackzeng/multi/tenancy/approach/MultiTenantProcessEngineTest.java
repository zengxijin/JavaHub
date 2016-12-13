package com.jackzeng.multi.tenancy.approach;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.asyncexecutor.multitenant.ExecutorPerTenantAsyncExecutor;
import org.activiti.engine.impl.asyncexecutor.multitenant.SharedExecutorServiceAsyncExecutor;
import org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jackzeng.multi.tenancy.approach.cfg.ProcessEngineCfg;

public class MultiTenantProcessEngineTest {

	private DummyTenantInfoHolder tenantInfoHolder; //多租户信息存储和管理，具有简单的路由功能
	private MultiSchemaMultiTenantProcessEngineConfiguration config; //针对多租户的流程引擎配置信息
	private ProcessEngine processEngine;
	
	private final static String MYSQL_URL = "jdbc:mysql://localhost:3306/"; //MySQL
	private final static String MYSQL_USER = "root";
	private final static String MYSQL_PWD = "admin";

	@Before
	public void setup() {
		setupTenantInfoHolder();
	}

	@After
	public void close() throws SQLException {
		if (processEngine != null) {
			processEngine.close();
		}
	}

	/**
	 * @Title: setupTenantInfoHolder   
	 * @Description: 租户信息初始化
	 * @param   
	 * @return void  
	 * @throws
	 */
	private void setupTenantInfoHolder() {
		DummyTenantInfoHolder tenantInfoHolder = new DummyTenantInfoHolder();

		tenantInfoHolder.addTenant("qf1"); //租户组Id
		tenantInfoHolder.addUser("qf1", "joram"); //对应租户组下的用户Id

		tenantInfoHolder.addTenant("qf2");
		tenantInfoHolder.addUser("qf2", "raphael");

		tenantInfoHolder.addTenant("qf3");
		tenantInfoHolder.addUser("qf3", "tony");

		this.tenantInfoHolder = tenantInfoHolder;
	}
	
	/**
	 * @Title: setupProcessEngine   
	 * @Description: 引擎初始化：租户组信息与对应数据库schema信息注册，数据库类型配置信息 
	 * @param @param sharedExecutor
	 * @param @throws ClassNotFoundException
	 * @param @throws SQLException  
	 * @return void  
	 * @throws
	 */
	private void setupProcessEngine(boolean sharedExecutor) throws ClassNotFoundException, SQLException {
		config = new MultiSchemaMultiTenantProcessEngineConfiguration(tenantInfoHolder);

		//config.setDatabaseType(MultiSchemaMultiTenantProcessEngineConfiguration.DATABASE_TYPE_H2);
		config.setDatabaseType(MultiSchemaMultiTenantProcessEngineConfiguration.DATABASE_TYPE_MYSQL); //数据库类型为MySQL
		config.setDatabaseSchemaUpdate(MultiSchemaMultiTenantProcessEngineConfiguration.DB_SCHEMA_UPDATE_DROP_CREATE); //先删除表再创建表
		config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);//数据库更新为true

		config.setAsyncExecutorEnabled(true);
		config.setAsyncExecutorActivate(true);

		if (sharedExecutor) {
			config.setAsyncExecutor(new SharedExecutorServiceAsyncExecutor(tenantInfoHolder));
		} else {
			config.setAsyncExecutor(new ExecutorPerTenantAsyncExecutor(tenantInfoHolder));
		}
		
		//简单的先删除租户对应的schema，测试使用，实际生产不应如此
		ProcessEngineCfg.dropAndCreateDatabase(MYSQL_URL, MYSQL_USER, MYSQL_PWD, "activiti_mt_qf1"); 
		//将对应的租户组tenantId跟对应的DataSource注册进去，之后由引擎自动管理，API通过tenantId自动得到对应的DataSource
		//如租户组tenantId:qf1 对应数据库的schema:activiti_mt_qf1
		config.registerTenant("qf1",
				createDataSource(MYSQL_URL + "activiti_mt_qf1", MYSQL_USER, MYSQL_PWD));
		
		ProcessEngineCfg.dropAndCreateDatabase(MYSQL_URL, MYSQL_USER, MYSQL_PWD, "activiti_mt_qf2");
		config.registerTenant("qf2", 
				createDataSource(MYSQL_URL + "activiti_mt_qf2", MYSQL_USER, MYSQL_PWD));
		
		ProcessEngineCfg.dropAndCreateDatabase(MYSQL_URL, MYSQL_USER, MYSQL_PWD, "activiti_mt_qf3");
		config.registerTenant("qf3",
				createDataSource(MYSQL_URL + "activiti_mt_qf3", MYSQL_USER, MYSQL_PWD));

		processEngine = config.buildProcessEngine();
	}

	@Test
	public void testStartProcessInstancesWithSharedExecutor() throws Exception {
		setupProcessEngine(true);
		runProcessInstanceTest();
	}

	// @Test
	public void testStartProcessInstancesWithExecutorPerTenantAsyncExecutor() throws Exception {
		setupProcessEngine(false);
		runProcessInstanceTest();
	}

	private void runProcessInstanceTest() throws InterruptedException, ClassNotFoundException, SQLException {
		//部署流程
		startProcessInstances("joram");
		assertData("joram", 2, 1);
		
		startProcessInstances("tony");
		startProcessInstances("tony");
		assertData("tony", 4, 2);
		
		startProcessInstances("raphael");
		//完成任务
		completeTasks("raphael");
		assertData("raphael", 0, 0);

		// Adding a new tenant 新增租户组和用户
		tenantInfoHolder.addTenant("qf4");
		tenantInfoHolder.addUser("qf4", "clark");
		//初始化对应的租户组下的schema
		ProcessEngineCfg.dropAndCreateDatabase(MYSQL_URL, MYSQL_USER, MYSQL_PWD, "activiti_mt_qf4");
		config.registerTenant("qf4",
				createDataSource(MYSQL_URL + "activiti_mt_qf4", MYSQL_USER, MYSQL_PWD));

		// Start process instance for new tenant
		startProcessInstances("clark");
		startProcessInstances("clark");
		assertData("clark", 4, 2);

		// Move the clock 2 hours (jobs fire in one hour)
		//config.getClock().setCurrentTime(new Date(config.getClock().getCurrentTime().getTime() + (2 * 60 * 60 * 1000)));
		Thread.sleep(2000L); // acquire time is 10 seconds, so 15 should be ok
		
		completeTasks("joram");
		completeTasks("tony");
		completeTasks("clark");

		assertData("joram", 0, 0);
		assertData("raphael", 0, 0);
		assertData("tony", 0, 0);
		assertData("clark", 0, 0);
	}

	private void startProcessInstances(String userId) {

		System.out.println();
		System.out.println("Starting process instance for user " + userId);

		tenantInfoHolder.setCurrentUserId(userId);
		
		//每次部署两个流程和启动2个流程测试
		Deployment deployment = processEngine.getRepositoryService().createDeployment()
				.addClasspathResource("diagrams/oneTaskProcess.bpmn20.xml")
				.addClasspathResource("diagrams/jobTest.bpmn20.xml").deploy();
		
		System.out.println("Process deployed! Deployment id is " + deployment.getId());

		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("data", "Hello from " + userId);

		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("oneTaskProcess",
				vars);
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId())
				.list();
		System.out.println("Got " + tasks.size() + " tasks");

		System.out.println("Got " + processEngine.getHistoryService().createHistoricProcessInstanceQuery().count()
				+ " process instances in the system");

		// Start a process instance with a Job
		processEngine.getRuntimeService().startProcessInstanceByKey("jobTest");

		tenantInfoHolder.clearCurrentUserId();
		tenantInfoHolder.clearCurrentTenantId();
	}

	private void completeTasks(String userId) {
		tenantInfoHolder.setCurrentUserId(userId);

		for (Task task : processEngine.getTaskService().createTaskQuery().list()) {
			processEngine.getTaskService().complete(task.getId());
		}

		tenantInfoHolder.clearCurrentUserId();
		tenantInfoHolder.clearCurrentTenantId();
	}

	private void assertData(String userId, long nrOfActiveProcessInstances, long nrOfActiveJobs) {
		tenantInfoHolder.setCurrentUserId(userId);
		

		Assert.assertEquals(nrOfActiveProcessInstances,
				processEngine.getRuntimeService().createProcessInstanceQuery().count());
		Assert.assertEquals(nrOfActiveProcessInstances,
				processEngine.getHistoryService().createHistoricProcessInstanceQuery().unfinished().count());
		Assert.assertEquals(nrOfActiveJobs, processEngine.getManagementService().createJobQuery().count());
		
		String tenantId = tenantInfoHolder.getCurrentTenantId();
		
		System.out.println(userId + ":" + tenantId + " deploy次数" + "=" + nrOfActiveJobs + " 未完成流程=" + nrOfActiveProcessInstances);
		
		tenantInfoHolder.clearCurrentUserId();
		tenantInfoHolder.clearCurrentTenantId();
	}

	// Helper //////////////////////////////////////////

	private DataSource createDataSource(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		//H2的DataSource
		// JdbcDataSource ds = new JdbcDataSource();
		// ds.setURL(jdbcUrl);
		// ds.setUser(jdbcUsername);
		// ds.setPassword(jdbcPassword);
		// return ds;
		
		//MySQL的DataSource
		try {
			return ProcessEngineCfg.createDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
