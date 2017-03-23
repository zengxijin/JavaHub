package org.jackzeng.kie.util;

import java.util.HashMap;
import java.util.Map;

import org.jackzeng.kie.cfg.KieServiceRawCfg;
import org.jackzeng.kie.constant.ResponseCode;
import org.jackzeng.kie.response.KieServiceResponse;

import com.alibaba.fastjson.JSONObject;

public class KieResponseHelper {
	public static KieServiceResponse parseKieRawResponse(String kieRawResponse,String appTransactionNo){
		KieServiceResponse resp = new KieServiceResponse();
		
		JSONObject obj = JSONObject.parseObject(kieRawResponse);
		resp.setMessage(obj.getString(KieServiceRawCfg.MSG));
		//成功
		if(KieServiceRawCfg.SUCCESS.equals(obj.getString(KieServiceRawCfg.TYPE))){
			JSONObject ret = obj.getJSONObject(KieServiceRawCfg.RESULT)
					            .getJSONObject(KieServiceRawCfg.EXECUTION_RESULTS);
			
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("appTransactionNo", appTransactionNo);
			data.put("results", ret.getJSONArray("results"));
			resp.setCode(ResponseCode.NORMAL.getCode());
			resp.setData(data);
		}else{
			resp.setCode(ResponseCode.INTERNAL_ERROR.getCode());
		}
		
		return resp;
		
	}
}
