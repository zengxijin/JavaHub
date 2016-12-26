package com.jackzeng.brms;


import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jackzeng.util.CRCBase64;

/**
 * @author XijinZeng 通过ScriptTask调用BRMS的规则库 规则库一般通过REST提供接口
 */
public class InvokeRulzDelegate implements JavaDelegate {
	private static final Logger LOGGER = LoggerFactory.getLogger(InvokeRulzDelegate.class);

	public void execute(DelegateExecution execution) throws Exception {
		Map<String, Object> flowVars = execution.getVariables();
		String restParamsBase64 = (String) flowVars.get("restParams");
		String restParams = CRCBase64.DecodeBase64(restParamsBase64);

		try {
			RulzRequestBean request = JSONObject.parseObject(restParams, RulzRequestBean.class);
			String response = InvokeRestHttp.execute(request);
			LOGGER.info(response);
			//parse the rulz response,normally it's json format
			String approvalPath = RulzReponseParse.dummyParse(response);
			execution.setVariable("FLOW_CODE_EX", approvalPath);

		} catch (Exception e) {
			LOGGER.error("call rulz error", e);
		}

	}

}
