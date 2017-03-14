package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.GetGlobalCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestGetGlobalCommand {

	public static GetGlobalCommand getRestJsonCmd(String identifier,String outIdentifier) {
		GetGlobalCommand cmd = new GetGlobalCommand();
		
		if(StringUtils.isNotBlank(identifier)){
			cmd.setIdentifier(identifier);
		}
		if(StringUtils.isNotBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		
		return cmd;
	}

	public static String getRestJson(String identifier,String outIdentifier) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(identifier,outIdentifier)
				);
	}
}
