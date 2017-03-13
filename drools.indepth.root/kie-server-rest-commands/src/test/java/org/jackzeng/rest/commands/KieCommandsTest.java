package org.jackzeng.rest.commands;

import java.util.ArrayList;
import java.util.List;

import org.drools.core.command.impl.GenericCommand;
import org.drools.core.command.runtime.BatchExecutionCommandImpl;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.jackzeng.rest.facts.UserInfo;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.runtime.helper.BatchExecutionHelper;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.ServiceResponse.ResponseType;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

public class KieCommandsTest {

	public static void main(String[] args) {
		KieCommandsTest cmds = new KieCommandsTest();
		cmds.executeCommands();
	}

	public void executeCommands() {
		long start = System.currentTimeMillis();
		String serverUrl = "http://172.16.4.39:8230/kie-server/services/rest/server";

		String user = "kieserver";
		String password = "kieserver";

		String containerId = "ruleFlow1.2";
		String processId = "ruleFlow.ruleFlow123";

		KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(serverUrl, user, password);

		configuration.setMarshallingFormat(MarshallingFormat.JAXB);
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);

		System.out.println("== Sending commands to the server ==");

		RuleServicesClient rulesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
		KieCommands commandsFactory = KieServices.Factory.get().getCommands();

		UserInfo info = new UserInfo("jackZeng", "公务员", 25, false, 5000.23);

		@SuppressWarnings("rawtypes")
		List<Command> cmds = new ArrayList<Command>();
		Command<?> insert = commandsFactory.newInsert(info);
		Command<?> fireAllRules = commandsFactory.newFireAllRules();
		Command<?> fireAllRulesOut = commandsFactory.newFireAllRules("abc");

		cmds.add(insert);
		cmds.add(fireAllRules);
		cmds.add(fireAllRulesOut);

		Command<?> batchCommand = commandsFactory.newBatchExecution(cmds);

		// 获取经过marshaller之后的json格式的数据
		String xml = BatchExecutionHelper.newJSonMarshaller().toXML(batchCommand);

		System.out.println(xml);

	}

	public void executeCommandsII() {
		String serverUrl = "http://172.16.4.39:8230/kie-server/services/rest/server";
		String user      = "kieserver";
		String password  = "kieserver";
		
		KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(serverUrl, user, password);
		configuration.setMarshallingFormat(MarshallingFormat.JAXB);
		
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
		RuleServicesClient rulesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
		// work with rules
		List<GenericCommand<?>> commands = new ArrayList<GenericCommand<?>>();
		BatchExecutionCommandImpl executionCommand = new BatchExecutionCommandImpl(commands);
		executionCommand.setLookup("defaultKieSession");

		InsertObjectCommand insertObjectCommand = new InsertObjectCommand();
		insertObjectCommand.setOutIdentifier("person");
		insertObjectCommand.setObject("john");

		FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();

		commands.add(insertObjectCommand);
		commands.add(fireAllRulesCommand);

		ServiceResponse<ExecutionResults> executeResponse = rulesClient.executeCommandsWithResults("hello",
				executionCommand);

		if (executeResponse.getType() == ResponseType.SUCCESS) {
			System.out.println("Commands executed with success! Response: ");
			System.out.println(executeResponse.getResult());
		} else {
			System.out.println("Error executing rules. Message: ");
			System.out.println(executeResponse.getMsg());
		}
	}

}
