package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.SetGlobalCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestSetGlobalCommand {

	public static SetGlobalCommand getRestJsonCmd(String identifier, Object object,String outIdentifier) {
		SetGlobalCommand cmd = new SetGlobalCommand();
		
		if(StringUtils.isNotBlank(identifier)){
			cmd.setIdentifier(identifier);
		}
		if(StringUtils.isNotBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		if(object != null){
			cmd.setObject(object);
		}
		
		return cmd;
	}

	public static String getRestJson(String identifier, Object object,String outIdentifier) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(identifier,object,outIdentifier)
				);
	}
}
