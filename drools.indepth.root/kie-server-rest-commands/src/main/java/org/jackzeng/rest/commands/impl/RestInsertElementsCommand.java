package org.jackzeng.rest.commands.impl;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.InsertElementsCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestInsertElementsCommand {
	public static InsertElementsCommand getRestJsonCmd(String entryPoint,Collection<Object> objects,boolean isReturnObject) {
		InsertElementsCommand cmd = new InsertElementsCommand();
		if(StringUtils.isNotBlank(entryPoint)){
			cmd.setEntryPoint(entryPoint);
		}
		if(objects != null && objects.size() > 0){
			cmd.setObjects(objects);
		}
		cmd.setReturnObject(isReturnObject);
		
		return cmd;
	}

	public static String getRestJson(String entryPoint,Collection<Object> objects,boolean isReturnObject) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				getRestJsonCmd(entryPoint,objects,isReturnObject)
				);
	}
}
