package org.jackzeng.kie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jackzeng.kie.cfg.BRMCServerInfo;
import org.jackzeng.kie.cfg.ProCfg;
import org.jackzeng.kie.constant.ResponseCode;
import org.jackzeng.kie.response.KieServiceResponse;
import org.jackzeng.kie.util.CloseableHttpHelper;
import org.jackzeng.kie.util.KieRequestHelper;
import org.jackzeng.kie.util.KieResponseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


/**
 * 进一步封装的对kie-server container的REST调用接口
 * 
 * @ClassName: KieServiceController
 * @Author:  XijinZeng 
 * @CreateDate: [2017-3-21 15:09:18]
 */

@RestController
@RequestMapping("/brmc")
public class KieServiceController {
	
	@Autowired
	private BRMCServerInfo serverInfo; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KieServiceController.class);
	
	private static final String rawPath = "/services/rest/server/containers/instances/"; 
	
	@RequestMapping(value = "/container/{version}/{ruleBase}", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public KieServiceResponse invokeKieService(
			@PathVariable("version") String version,
			@PathVariable("ruleBase") String ruleBase,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody String message
			)
	{
		LOGGER.info(message);
		
		KieServiceResponse resp = new KieServiceResponse();
		
		JSONObject json    = JSONObject.parseObject(message);
		String category    = json.getString("category");
		String appTransactionNo = json.getString("appTransactionNo");
		
		Map<String,String> categoryInfo = serverInfo.getInfoMap().get(category);
		
		//此分类没有配置对应的kie-server服务器资源，拒绝服务
		if(categoryInfo == null){
			resp.setCode(ResponseCode.RESOURCES_NOT_EXISTS.getCode());
			resp.setMessage("category " + category + " has no mapping resources");
			return resp;
		}
		
		String server          = categoryInfo.get(ProCfg.KEY_SERVER);
		String basicAuthHeader = categoryInfo.get(ProCfg.KEY_BASICAUTH);
		
		//认证信息
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put(ProCfg.KEY_BASICAUTH, basicAuthHeader);
		
		String requestUrl = server + rawPath + ruleBase + version;
		
		String requestBody = KieRequestHelper.assembleKieRest(JSONObject.parseObject(message)).toJSONString();
		
		try {
			//调用kie-server集群
			String kieResponse = CloseableHttpHelper.postRequest(requestUrl, requestBody, headers);
			LOGGER.info(kieResponse);
			
			//解析结果
			resp = KieResponseHelper.parseKieRawResponse(kieResponse, appTransactionNo);
			LOGGER.info(JSONObject.toJSONString(resp));
		} catch (Exception e) {
			LOGGER.error("invokeKieService error",e);
			resp.setCode(ResponseCode.INTERNAL_ERROR.getCode());
			resp.setMessage("internal error");
		}
		
		return resp;
	}
}
