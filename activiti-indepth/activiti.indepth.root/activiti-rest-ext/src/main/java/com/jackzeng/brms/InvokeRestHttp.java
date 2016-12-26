package com.jackzeng.brms;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackzeng.util.CRCBase64;
import com.jackzeng.util.http.HttpHelper;
import com.jackzeng.util.http.HttpMethod;


public class InvokeRestHttp {
	public static String execute(RulzRequestBean request) throws Exception {
		if(request == null || StringUtils.isBlank(request.getRestUrl())){
			throw new Exception("invalid request");
		}
		
		String httpMethod = request.getHttpMethod();
		if(StringUtils.isBlank(httpMethod)){
			throw new Exception("empty http method");
		}
		httpMethod = httpMethod.toUpperCase().trim();
		String restUrl    = request.getRequestUrlWithUrlParams();
		String bodyParams = CRCBase64.DecodeBase64(request.getBodyParams());
		String isEncrypt  = request.getIsEncrypt();
		String encryptAgl = request.getEncryptAgl();
		Map<String,String> headersMap = getMapHeaders(request.getHeaderParams());
		
		//if the content is encrypted, decrypt the content first
		if("true".equals(isEncrypt)){
			//todo:解密内容
		}
		
		if (HttpMethod.POST.equals(httpMethod)) {
			 return HttpHelper.postRequest(restUrl,bodyParams, headersMap);
		}else if(HttpMethod.GET.equals(httpMethod)){
			return HttpHelper.getRequest(restUrl, headersMap);
		}else if(HttpMethod.PUT.equals(httpMethod)){
			return HttpHelper.putRequest(restUrl, bodyParams, headersMap);
		}else if(HttpMethod.DELETE.equals(httpMethod)){
			return HttpHelper.deleteRequest(restUrl, headersMap);
		}else{
			throw new Exception("unsupported http method:" + httpMethod);
		}
	}

	public static Map<String, String> getMapHeaders(String jsonArray) {
		if (StringUtils.isBlank(jsonArray)) {
			return null;
		}

		Map<String, String> map = new HashMap<String, String>();
		JSONArray array = JSONObject.parseArray(jsonArray);
		for (int i = 0; i < array.size(); i++) {
			map.put(
					array.getJSONObject(i).getString("key"), 
					array.getJSONObject(i).getString("value")
					);
		}

		return map;
	}
}
