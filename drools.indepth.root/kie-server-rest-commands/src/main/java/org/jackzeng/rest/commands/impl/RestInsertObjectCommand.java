package org.jackzeng.rest.commands.impl;

import org.apache.commons.lang.StringUtils;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.jackzeng.rest.KieServerRestCmds;

public class RestInsertObjectCommand {

	public static InsertObjectCommand getRestJsonCmd(String entryPoint, String outIdentifier, boolean isReturnObject,
			Object data) {
		InsertObjectCommand cmd = new InsertObjectCommand();
		if (StringUtils.isNotBlank(entryPoint)) {
			cmd.setEntryPoint(entryPoint);
		}
		if (StringUtils.isNotBlank(outIdentifier)) {
			cmd.setOutIdentifier(outIdentifier);
		}
		if (data != null) {
			cmd.setObject(data);
		}
		cmd.setReturnObject(isReturnObject);
		return cmd;
	}

	public static String getRestJson(String entryPoint, String outIdentifier, boolean isReturnObject, Object data) {
		return KieServerRestCmds.getCmdsInJsonWithoutBatchNode(
				  getRestJsonCmd(entryPoint, outIdentifier, isReturnObject, data)
				);
	}
}
