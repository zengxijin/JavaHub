package com.jackzeng.engine.api;

import java.io.ByteArrayInputStream;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.ActivitiListener;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ImplementationType;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.impl.util.io.InputStreamSource;
import org.activiti.engine.repository.Deployment;

public class BpmnModelApi {
	ProcessEngineConfiguration engineCfg = new StandaloneProcessEngineConfiguration();
	ProcessEngine engine = engineCfg.buildProcessEngine();
	RepositoryService repositoryService = engine.getRepositoryService();
	
	public void testStartEventWithExecutionListener() throws Exception {
	    BpmnModel bpmnModel = new BpmnModel();
	    
	    Process process = new Process();
	    process.setId("simpleProcess");
	    process.setName("Very simple process");
	    bpmnModel.getProcesses().add(process);
	    
	    StartEvent startEvent = new StartEvent();
	    startEvent.setId("startEvent1");
	    
	    TimerEventDefinition timerDef = new TimerEventDefinition();
	    timerDef.setTimeDuration("PT5M");
	    
	    startEvent.getEventDefinitions().add(timerDef);
	    
	    ActivitiListener listener = new ActivitiListener();
	    listener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION);
	    listener.setImplementation("${test}");
	    listener.setEvent("end");
	    
	    startEvent.getExecutionListeners().add(listener);
	    
	    process.addFlowElement(startEvent);
	    
	    UserTask task = new UserTask();
	    task.setId("reviewTask");
	    task.setAssignee("kermit");
	    process.addFlowElement(task);
	    
	    SequenceFlow flow1 = new SequenceFlow();
	    flow1.setId("flow1");
	    flow1.setSourceRef("startEvent1");
	    flow1.setTargetRef("reviewTask");
	    
	    process.addFlowElement(flow1);
	    
	    EndEvent endEvent = new EndEvent();
	    endEvent.setId("endEvent1");
	    process.addFlowElement(endEvent);
	    
	    byte[] xml = new BpmnXMLConverter().convertToXML(bpmnModel);
	    
	    new BpmnXMLConverter().validateModel(new InputStreamSource(new ByteArrayInputStream(xml)));
	    
	    Deployment deployment = repositoryService.createDeployment().name("test").addString("test.bpmn20.xml", new String(xml)).deploy();
	    repositoryService.deleteDeployment(deployment.getId());
	  }
}
