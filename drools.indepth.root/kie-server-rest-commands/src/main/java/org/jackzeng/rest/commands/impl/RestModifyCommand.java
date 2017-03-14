package org.jackzeng.rest.commands.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.ModifyCommand;
import org.drools.core.common.DisconnectedFactHandle;
import org.jackzeng.rest.KieServerRestCmds;
import org.kie.api.command.Setter;

public class RestModifyCommand {
	public static ModifyCommand getRestJsonCmd(DisconnectedFactHandle factHandle,String factHandleId,List<Setter> setters) {
		ModifyCommand cmd = new ModifyCommand();
		if(factHandle != null){
			cmd.setFactHandle(factHandle);
		}
		if(StringUtils.isNotBlank(factHandleId)){
			cmd.setFactHandleFromString(factHandleId);
		}
		if(setters != null){
			cmd.setSetters(setters);
		}
		return cmd;
	}

	public static String getRestJson(DisconnectedFactHandle factHandle,String factHandleId,List<Setter> setters) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(factHandle,factHandleId,setters)
				);
	}
}
