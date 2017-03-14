package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.GetObjectsCommand;
import org.jackzeng.rest.KieServerRestCmds;
import org.kie.api.runtime.ObjectFilter;

public class RestGetObjectsCommand {
	
	public static GetObjectsCommand getRestJsonCmd(ObjectFilter filter,String outIdentifier) {
		GetObjectsCommand cmd = new GetObjectsCommand();
		
		if(filter != null){
			cmd.setFilter(filter);
		}
		if(StringUtils.isNotBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		
		return cmd;
	}

	public static String getRestJson(ObjectFilter filter,String outIdentifier) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(filter,outIdentifier)
				);
	}
}
