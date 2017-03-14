package org.jackzeng.rest.commands.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.process.StartProcessCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestStartProcessCommand {
	
	public static StartProcessCommand getRestJsonCmd(String processId,Map<String,Object> parameters,
			String outIdentifier,List<Object> data) {
		StartProcessCommand cmd = new StartProcessCommand();
		if(StringUtils.isNotBlank(processId)){
			cmd.setProcessId(processId);
		}
		if(parameters != null && !parameters.isEmpty() ){
			cmd.setParameters(parameters);
		}
		if(StringUtils.isNotBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		if(data != null && !data.isEmpty()){
			cmd.setData(data);
		}
		
		return cmd;
	}

	public static String getRestJson(String processId,Map<String,Object> parameters,
			String outIdentifier,List<Object> data) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(processId,parameters,outIdentifier,data)
				);
	}
}
