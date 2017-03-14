package org.jackzeng.rest.commands.impl;

import java.util.Map;

import org.drools.core.command.runtime.process.CompleteWorkItemCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestCompleteWorkItemCommand {
	
	public static CompleteWorkItemCommand getRestJsonCmd(Long workItemId,Map<String,Object> results) {
		CompleteWorkItemCommand cmd = new CompleteWorkItemCommand();
		
		cmd.setWorkItemId(workItemId);
		if(results != null && !results.isEmpty()){
			cmd.setResults(results);
		}
		
		return cmd;
	}

	public static String getRestJson(Long workItemId,Map<String,Object> results) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(workItemId,results)
				);
	}
}
