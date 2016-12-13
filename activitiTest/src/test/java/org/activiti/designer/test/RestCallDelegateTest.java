package org.activiti.designer.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class RestCallDelegateTest {
	@Test
	public void test(){
		ProcessEngine processEngine = new StandaloneInMemProcessEngineConfiguration()
				.buildProcessEngine();
		RepositoryService repositoryService =  processEngine.getRepositoryService();
		RuntimeService runtimeService =  processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		
		
		repositoryService.createDeployment().addClasspathResource("diagrams/CallServiceFlow.bpmn")
		.deploy();
		
		Map<String,Object> var = new HashMap<String, Object>();
		String url = "http://127.0.0.1:8080/crc-bpm-rest-5.22.0/service/repository/deployments/20";
		var.put("url", url);
		
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("CallServiceFlow",var);
		
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId())
				.list();
		
		for(Task task : tasks){
			System.out.println("Task info:" + task.getName());
		}
				
	}
}
