package org.jackzeng.rest.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jackzeng.rest.KieServerRestCmds;
import org.jackzeng.rest.commands.impl.RestStartProcessCommand;
import org.jackzeng.rest.facts.UserInfo;
import org.kie.api.command.Command;

public class RestCmdsTest {

	public static void main(String[] args) {
		RestCmdsTest test = new RestCmdsTest();
		test.startProcessCmd();
	}
	
	public void startProcessCmd(){
		Map<String,Object> parameters = new HashMap<String,Object>();
		UserInfo info = new UserInfo("jackzeng", "公务员", 20, true, 4567.123);
		parameters.put("userInfo", info);
		parameters.put("intVal", 123);
		List<Object> data = new ArrayList<Object>();
		Command<?> cmd = RestStartProcessCommand.getRestJsonCmd("qf.myProcessId", parameters, "outKey", data);
		String json = KieServerRestCmds.getCmdsInJsonWithoutBatchNode(cmd);
		System.out.println(json);
	}

}
