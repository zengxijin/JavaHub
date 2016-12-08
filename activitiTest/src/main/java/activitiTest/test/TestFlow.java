package activitiTest.test;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.ldap.LDAPConfigurator;
import org.activiti.ldap.LDAPGroupManager;
import org.activiti.ldap.LDAPTemplate;
import org.activiti.ldap.LDAPUserManager;

public class TestFlow {

	public static void main(String[] args) {
		//配置activiti.cfg.xml文件，指定bean的class类型，否则有问题的话会出现NullPointException，默认是
		//H2内存数据库org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		//获取流程文件存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		//获取运行服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		//获取流程任务组件
		TaskService taskService = engine.getTaskService();
		
		//部署流程
		repositoryService.createDeployment().addClasspathResource("diagrams/testFlow.bpmn").deploy();
		
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("name", "zengxijin");
		
		//这里的key一定要与.bpmn的文件里process的id一致，可以在Properties属性里设置
		ProcessInstance inst = runtimeService.startProcessInstanceByKey("testFlow",variables);

		Task task = null;
		do {
			task = taskService.createTaskQuery().processInstanceId(inst.getProcessInstanceId()).singleResult();
			System.out.println(task);
			if (task != null) {
				taskService.complete(task.getId());
			}
		} while (task != null);
		
		LDAPConfigurator ldapConfigurator = new LDAPConfigurator();
		ldapConfigurator.setServer("ldap://quark.com");  //域控服务器
		ldapConfigurator.setPort(389);                   //默认389端口
		ldapConfigurator.setUser("XijinZeng@quark.com"); //用户，默认是 用户名@域控
		ldapConfigurator.setPassword("********");     //密码
		ldapConfigurator.setUserBaseDn("OU=IT部,OU=上海总部,OU=QuarkFinance,DC=quark,DC=com"); //查找域控的群组或者范围
		
		LDAPUserManager userManager = new LDAPUserManager(ldapConfigurator); //使用User的API
		//LDAPGroupManager groupManager = new LDAPGroupManager(lDAPConfigurator); //使用Group的API
		
		//根据java底层javax.naming的语法格式查找用户，name=用户名，checkPassword是activiti封装LDAP认证的接口
		Boolean checkPassword = 
				userManager.checkPassword("(&(objectCategory=person)(objectClass=user)(name=Xijin Zeng))", "******");
		//通过返回true
		System.out.println(checkPassword);

		
	}

}
