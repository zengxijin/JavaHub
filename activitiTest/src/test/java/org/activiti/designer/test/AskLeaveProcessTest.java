package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * @author XijinZeng
 * 2016-12-08 18:34:12
 */
public class AskLeaveProcessTest {
	
	@Test
	public void test(){
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")   //使用MySQL的配置信息
				.buildProcessEngine();
		
		RepositoryService repositoryService = processEngine.getRepositoryService(); //查询信息服务相关
		RuntimeService    runtimeService    = processEngine.getRuntimeService();    //流程控制相关
		TaskService       taskService       = processEngine.getTaskService();       //任务控制和查询相关
		IdentityService   identityService   = processEngine.getIdentityService();   //用户认证、修改相关
		
		//删除askLeave流程相关的历史数据
		List<ProcessDefinition> list= repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionKey("askLeave").list();
		
		System.out.println("found askLeave:" + list.size());
		
		if(!list.isEmpty()){
			for(ProcessDefinition pd : list){
				System.out.println("deleted: name=" + pd.getName() + " id="+ pd.getId() + " DeploymentId=" + pd.getDeploymentId());
				//要使用下面接口干净的删除历史部署的流程，否则会报myBatis外键删除报错
				repositoryService.deleteDeployment(pd.getDeploymentId(), true);
			}
		}
		
		
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagrams/askLeave.bpmn").deploy();
		
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionKey("askLeave").deploymentId(deployment.getId())
				.singleResult();
		
		assertEquals("askLeave",processDefinition.getKey());
		String deploymentId = processDefinition.getDeploymentId();
		System.out.println("askLeave deploymentId=" + deploymentId);
		
		//out:println "apply user:" + applyUser + " ask leave days: " + askLeaveDays + " approval status:" + approveStatus;
		Map<String,Object> variables =new HashMap<String,Object>();
		variables.put("applyUser", "XijinZeng");
		variables.put("askLeaveDays", "10");
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("askLeave",variables);
		assertNotNull(processInstance);
		
		//验证group
		assert(identityService.createGroupQuery().groupName("management").count() > 0); 
		Task manageTask = taskService.createTaskQuery()
				.taskCandidateGroup("management")
				.deploymentId(deploymentId)
				.singleResult();
		assertNotNull(manageTask);
		assertEquals("manage task", manageTask.getName());
		
		//验证user
		assert(identityService.checkPassword("kermit", "kermit")); 
		taskService.claim(manageTask.getId(), "kermit");
		variables.put("approveStatus", "pass");
		taskService.complete(manageTask.getId(),variables);
		
		manageTask = taskService.createTaskQuery()
				.taskCandidateGroup("management")
				.deploymentId(deploymentId)
				.singleResult();
		assertNull(manageTask);
		
		HistoryService historyService = processEngine.getHistoryService();
		long count = historyService.createHistoricProcessInstanceQuery()
				.deploymentId(deployment.getId())
				.finished().count();
		assert(count == 1); 
		
		System.out.println("finished task:" + count);
	}

}
