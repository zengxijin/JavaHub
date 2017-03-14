package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.DeleteCommand;
import org.drools.core.common.DisconnectedFactHandle;
import org.jackzeng.rest.KieServerRestCmds;

public class RestDeleteCommand {
	public static DeleteCommand getRestJsonCmd(String factHandleId, DisconnectedFactHandle factHandle) {
		DeleteCommand cmd = new DeleteCommand();
		if(StringUtils.isNotBlank(factHandleId)){
			cmd.setFactHandleFromString(factHandleId);
		}
		if(factHandle != null){
			cmd.setHandle(factHandle);
		}
		
		return cmd;
	}

	public static String getRestJson(String factHandleId, DisconnectedFactHandle factHandle) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(factHandleId,factHandle)
				);
	}
}
