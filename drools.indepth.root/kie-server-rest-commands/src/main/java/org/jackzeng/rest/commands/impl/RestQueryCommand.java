package org.jackzeng.rest.commands.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.drools.core.command.runtime.rule.QueryCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestQueryCommand {

	public static QueryCommand getRestJsonCmd(String name,String outIdentifier, List<Object> arguments) {
		QueryCommand cmd = new QueryCommand();
		if(StringUtils.isNoneBlank(name)){
			cmd.setName(name);
		}
		if(StringUtils.isNoneBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		if(arguments != null && !arguments.isEmpty()){
			cmd.setArguments(arguments);
		}
		
		return cmd;
	}

	public static String getRestJson(String name,String outIdentifier, List<Object> arguments) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(name,outIdentifier,arguments)
				);
	}
}
