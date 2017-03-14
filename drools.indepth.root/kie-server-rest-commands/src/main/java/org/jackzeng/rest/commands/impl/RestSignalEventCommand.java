package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.process.SignalEventCommand;
import org.jackzeng.rest.KieServerRestCmds;
import org.kie.internal.process.CorrelationKey;

public class RestSignalEventCommand {

	public static SignalEventCommand getRestJsonCmd(Long processInstanceId,Object event,
			String eventType,CorrelationKey correlationKey) {
		SignalEventCommand cmd = new SignalEventCommand();
		
		cmd.setProcessInstanceId(processInstanceId);
		if(event != null){
			cmd.setEvent(event);
		}
		if(StringUtils.isNotBlank(eventType)){
			cmd.setEventType(eventType);
		}
		if(correlationKey != null){
			cmd.setCorrelationKey(correlationKey);
		}
		
		return cmd;
	}

	public static String getRestJson(Long processInstanceId,Object event,
			String eventType,CorrelationKey correlationKey) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(processInstanceId,event,eventType,correlationKey)
				);
	}
}
