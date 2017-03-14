package org.jackzeng.rest.commands.impl;

import org.drools.core.command.runtime.process.AbortWorkItemCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestAbortWorkItemCommand {

	public static AbortWorkItemCommand getRestJsonCmd(Long workItemId) {
		AbortWorkItemCommand cmd = new AbortWorkItemCommand();
		
		cmd.setWorkItemId(workItemId);
		
		return cmd;
	}

	public static String getRestJson(Long workItemId) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(workItemId)
				);
	}
}
