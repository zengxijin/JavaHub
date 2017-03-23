package org.jackzeng.rest.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.core.common.DisconnectedFactHandle;
import org.jackzeng.rest.KieServerRestCmds;
import org.jackzeng.rest.commands.impl.RestDeleteCommand;
import org.jackzeng.rest.commands.impl.RestInsertObjectCommand;
import org.jackzeng.rest.commands.impl.RestQueryCommand;
import org.jackzeng.rest.commands.impl.RestStartProcessCommand;
import org.jackzeng.rest.facts.UserInfo;
import org.jackzeng.rest.facts.UserScore;
import org.kie.api.command.Command;

public class RestCmdsTest {

	public static void main(String[] args) {
		RestCmdsTest test = new RestCmdsTest();
		test.startProcessCmd();
		test.deleteObjectCmd();
		test.queryCmd();
		test.insertObjectCmd();
	}
	
	public void insertObjectCmd(){
		UserInfo info = new UserInfo("jackzeng", "高级开发", 30, true, 5000);
		UserScore score = new UserScore(50, "A100");
		
		String json = RestInsertObjectCommand.getRestJson(null, "123", true, info) ;
		System.out.println(json);
	}
	
	public void startProcessCmd(){
		Map<String,Object> parameters = new HashMap<String,Object>();
		UserInfo info = new UserInfo("jackzeng", "公务员", 20, true, 4567.123);
		parameters.put("userInfo", info);
		parameters.put("intVal", 123);
		List<Object> data = new ArrayList<Object>();
		data.add(info);
		Command<?> cmd = RestStartProcessCommand.getRestJsonCmd("qf.myProcessId", parameters, "outKey", data);
		String json = KieServerRestCmds.getCmdsInJsonWithoutBatchNode(cmd);
		String json2 = KieServerRestCmds.getCmdsInJson(cmd);
		System.out.println(json);
		System.out.println(json2);
	}
	
	public void queryCmd(){
		List<Object> list = new ArrayList<Object>();
		UserInfo info = new UserInfo("jackzeng", "公务员", 20, true, 4567.123);
		list.add(info);
		list.add("koko");
		list.add(new UserInfo("James", "老师", 20, true, 4567.123));
		String json = RestQueryCommand.getRestJson("myQuery", "myOut", list);
		System.out.println(json);
	}
	
	public void deleteObjectCmd(){
		String json = RestDeleteCommand.getRestJson("0:1:825561880:825561880:1:DEFAULT:NON_TRAIT:com.qf.projecta.ABean", null);
		System.out.println(json);
	}

}
