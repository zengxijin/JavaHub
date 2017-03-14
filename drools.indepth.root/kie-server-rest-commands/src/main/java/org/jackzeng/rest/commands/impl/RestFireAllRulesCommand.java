package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.jackzeng.rest.KieServerRestCmds;
import org.kie.api.runtime.rule.AgendaFilter;

public class RestFireAllRulesCommand {
	/**
	 * @Title: getRestJsonCmd   
	 * @Description: TODO  
	 * @param @param max 如果小于0，则不需要设置
	 * @param @param factHandle
	 * @param @return  
	 * @return FireAllRulesCommand  
	 * @throws
	 */
	public static FireAllRulesCommand getRestJsonCmd(int max, String outIdentifier,AgendaFilter agendaFilter) {
		FireAllRulesCommand cmd = new FireAllRulesCommand();
		if(max < 0){
			cmd.setMax(max);
		}
		if(StringUtils.isNotBlank(outIdentifier)){
			cmd.setOutIdentifier(outIdentifier);
		}
		if(agendaFilter != null){
			cmd.setAgendaFilter(agendaFilter);
		}
		
		return cmd;
	}

	public static String getRestJson(int max, String outIdentifier,AgendaFilter agendaFilter) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(max,outIdentifier,agendaFilter)
				);
	}
}
