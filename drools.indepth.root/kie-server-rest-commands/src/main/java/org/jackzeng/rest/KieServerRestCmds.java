package org.jackzeng.rest;

import java.util.Arrays;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.internal.runtime.helper.BatchExecutionHelper;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: KieServerRestCmds
 * @author:  Jack Zeng 
 * @CreateDate: [2017年3月13日 下午4:46:32]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2017年3月13日 下午4:46:32]   
 * @UpdateRemark: [TODO()]
 * @Description:  [kie-server的服务封装参数]
 * @version: [V1.0]
 */
public class KieServerRestCmds {

	private volatile static KieCommands kieCommands = null;
	
	public static KieCommands getKieCommands(){
		if(kieCommands == null){
			synchronized (KieServerRestCmds.class) {
				if(kieCommands == null){
					kieCommands = KieServices.Factory.get().getCommands();
				}
			}
		}
		return kieCommands;
	}

	
	
	public static String getCmdsInJson(Command<?> ...cmd){
		List<Command<?>> list = Arrays.asList(cmd);
		BatchExecutionCommand bec = getKieCommands().newBatchExecution(list);
		return BatchExecutionHelper.newJSonMarshaller().toXML(bec);
	}
	
	/**
	 * the return json node "batch-execution" is removed
	 */
	public static String getCmdsInJsonWithoutBatchNode(Command<?> ...cmd){
		return JSONObject.parseObject(
				getCmdsInJson(cmd)
				).getJSONObject("batch-execution").toJSONString();
	}

}
