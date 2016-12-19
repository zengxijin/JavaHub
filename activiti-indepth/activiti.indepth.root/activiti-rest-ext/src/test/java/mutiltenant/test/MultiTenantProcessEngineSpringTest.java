package mutiltenant.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.asyncexecutor.multitenant.ExecutorPerTenantAsyncExecutor;
import org.activiti.engine.impl.asyncexecutor.multitenant.SharedExecutorServiceAsyncExecutor;
import org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jackzeng.mutiltenant.DummyTenantInfoHolder;
import com.jackzeng.mutiltenant.cfg.MultiTenantDBCfg;
import com.jackzeng.mutiltenant.cfg.ProcessEngineCfg;
import com.jackzeng.mutiltenant.cfg.UserTenantMapper;
import com.jackzeng.mutiltenant.cfg.UserTenantMapperHolder;

public class MultiTenantProcessEngineSpringTest {

	private DummyTenantInfoHolder tenantInfoHolder; //多租户信息存储和管理，具有简单的路由功能
	private MultiSchemaMultiTenantProcessEngineConfiguration config; //针对多租户的流程引擎配置信息
	private ProcessEngine processEngine;
	
	//Spring注入配置信息
	ApplicationContext context = new ClassPathXmlApplicationContext("crc-mutiltenant-cfg-test.xml");
	
	private static String MYSQL_URL; // = "jdbc:mysql://localhost:3306/"; //MySQL
	private static String MYSQL_USER;// = "root";
	private static String MYSQL_PWD; // = "admin";
	

	@Before
	public void setup() {
		setupTenantInfoHolder();
		
		//根据activiti.mutiltenant.cfg.xml配置信息，初始化数据库信息
		MultiTenantDBCfg dbCfg = (MultiTenantDBCfg)context.getBean("multiTenantDBCfg");
		MYSQL_URL = dbCfg.getJdbcUrl();
		MYSQL_USER = dbCfg.getJdbcUser();
		MYSQL_PWD = dbCfg.getJdbcPassword();
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
		//根据activiti.mutiltenant.cfg.xml配置信息，初始化租户组和租户信息
		DummyTenantInfoHolder tenantInfoHolder = (DummyTenantInfoHolder)context.getBean("dummyTenantInfoHolder");
		UserTenantMapperHolder userTenantMapperHolder = (UserTenantMapperHolder)context.getBean("userTenantMapperHolder");
		
		List<UserTenantMapper> list = userTenantMapperHolder.getUserTenantMapperInfo();
		if(list.size() > 0){
			for(UserTenantMapper utm : list){
				Map<String,List<String>> map = utm.getUserTenant();
				Iterator<Entry<String, List<String>>> it = map.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String,List<String>> entry = it.next();
					String tenantId = entry.getKey();
					List<String> tenantUserIds = entry.getValue();
					tenantInfoHolder.addTenant(tenantId);
					for(String userId : tenantUserIds){
						tenantInfoHolder.addUser(tenantId, userId);
					}
				}
			}
		}
		
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

		config.setDatabaseType(MultiSchemaMultiTenantProcessEngineConfiguration.DATABASE_TYPE_MYSQL); //数据库类型为MySQL
		config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);//数据库更新为true

		config.setAsyncExecutorEnabled(true);
		config.setAsyncExecutorActivate(true);
		

		if (sharedExecutor) {
			config.setAsyncExecutor(new SharedExecutorServiceAsyncExecutor(tenantInfoHolder));
		} else {
			config.setAsyncExecutor(new ExecutorPerTenantAsyncExecutor(tenantInfoHolder));
		}
		
		//根据activiti.mutiltenant.cfg.xml配置信息
		UserTenantMapperHolder userTenantMapperHolder = (UserTenantMapperHolder)context.getBean("userTenantMapperHolder");
		List<UserTenantMapper> list = userTenantMapperHolder.getUserTenantMapperInfo();
		if(list.size() > 0){
			for(UserTenantMapper utm : list){
				Map<String,List<String>> map = utm.getUserTenant();
				Iterator<Entry<String, List<String>>> it = map.entrySet().iterator();
				String tenantId = null;
				while(it.hasNext()){
					Map.Entry<String,List<String>> entry = it.next();
					tenantId = entry.getKey();
				}
				//简单的先删除租户对应的schema，测试使用，实际生产不应如此，纯粹为了测试
				ProcessEngineCfg.dropAndCreateDatabase(MYSQL_URL, MYSQL_USER, MYSQL_PWD, utm.getTenantSchema());
				config.registerTenant(tenantId, createDataSource(MYSQL_URL + utm.getTenantSchema(), MYSQL_USER, MYSQL_PWD));
			}
		}
		
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

	//请根据配置文件修改对应的测试用户数据
	private void runProcessInstanceTest() throws InterruptedException, ClassNotFoundException, SQLException {
		//部署流程
		startProcessInstances("tenantA_user1");
		assertData("tenantA_user1", 2, 1);
		
		startProcessInstances("tenantB_user3");
		startProcessInstances("tenantB_user3");
		assertData("tenantB_user3", 4, 2);
		
		startProcessInstances("tenantC_user5");
		//完成任务
		completeTasks("tenantC_user5");
		assertData("tenantC_user5", 0, 0);

		Thread.sleep(2000L); 
		
		completeTasks("tenantA_user1");
		completeTasks("tenantB_user3");

		assertData("tenantA_user1", 0, 0);
		assertData("tenantB_user3", 0, 0);
		assertData("tenantC_user5", 0, 0);
		
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

	private DataSource createDataSource(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		//MySQL的DataSource
		try {
			return ProcessEngineCfg.createDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
