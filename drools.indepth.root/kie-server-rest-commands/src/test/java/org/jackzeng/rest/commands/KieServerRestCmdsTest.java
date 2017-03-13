package org.jackzeng.rest.commands;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.jackzeng.rest.KieServerRestCmds;
import org.jackzeng.rest.facts.UserInfo;

public class KieServerRestCmdsTest {

	public static void main(String[] args) {
		UserInfo info = new UserInfo("zengxijin", "软件工程师", 25, true, 5000.123);
		
		InsertObjectCommand insertObjectCommand = new InsertObjectCommand();
		insertObjectCommand.setOutIdentifier("userInfo");
		insertObjectCommand.setObject(info);
		insertObjectCommand.setReturnObject(false);
		

		FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
		fireAllRulesCommand.setMax(100);
		fireAllRulesCommand.setOutIdentifier("myKey");
		
		String jsonWithBatch = KieServerRestCmds.getCmdsInJson(
				insertObjectCommand,
				fireAllRulesCommand
				);
		
		String jsonWithoutBatch = KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				insertObjectCommand,
				fireAllRulesCommand
				);
		
		System.out.println(jsonWithBatch + "\n" + jsonWithoutBatch);
	}

}
