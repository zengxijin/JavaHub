package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.GetObjectCommand;
import org.jackzeng.rest.KieServerRestCmds;
import org.kie.api.runtime.rule.FactHandle;

public class RestGetObjectCommand {
	public static GetObjectCommand getRestJsonCmd(String factHandleId,FactHandle factHandle,String outIdentifier) {
		GetObjectCommand cmd = new GetObjectCommand();
		if(StringUtils.isNotBlank(factHandleId)){
			cmd.setFactHandleFromString(factHandleId);
		}
		if(factHandle != null){
			cmd.setFactHandle(factHandle);
		}
		if(StringUtils.isNotBlank(outIdentifier) ){
			cmd.setOutIdentifier(outIdentifier);
		}
		
		return cmd;
	}

	public static String getRestJson(String factHandleId,FactHandle factHandle,String outIdentifier) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(factHandleId,factHandle,outIdentifier)
				);
	}
}
