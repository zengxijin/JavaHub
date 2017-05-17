package com.mule.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PostCloseableHttp {

	public static void main(String[] args) {
		try {
			Map<String,String> mm = new HashMap<String,String>();
			mm.put("Content-Type", "application/json");
			mm.put("Authorization", "sadksjadlaksjd");
			String sss = postRequest("http://localhost:9080/springmvc/hello?aa=true","{\"Id\":\"123\"}",mm,
					10*1000,65*1000);
			System.out.println(sss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String postRequest(String url, String requestbody, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		System.out.println(PostCloseableHttp.class + " url=" + url + " requestbody=" + requestbody + " headers="
				+ headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );
		
		String result = null;
		
		/**DefaultHttpRequestRetryHandler 默认会重试3次*/
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
		CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        
        try {
			httpPost = new HttpPost(url);
			//请求头非空，进行组装
			if ((headers != null) && (headers.isEmpty() == false)) {
				for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
					httpPost.addHeader(entryLoc.getKey(), entryLoc.getValue());
				}
			}
			//连接和响应超时设置，必须大于0
			if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
				RequestConfig.Builder customReqConf = RequestConfig.custom()
						.setConnectTimeout(connTimeoutSeconds)
						.setSocketTimeout(socketTimeoutSeconds);
				httpPost.setConfig(customReqConf.build());
			}
			//请求body
			if( requestbody != null && requestbody != "" ){
				StringEntity stringEntity = new StringEntity(requestbody,"UTF-8");
				httpPost.setEntity(stringEntity);
			}
			
			//post request
			response = httpClient.execute(httpPost);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			
			if(response.getStatusLine().getStatusCode() != 200) {
				System.out.println("statusCode：" + response.getStatusLine().getStatusCode());
			}
			
			return result;
			
		} catch (Exception e) {
			System.out.println("服务异常！" + e);
			throw e;
		} finally {
			if(response != null){
				response.close();
			}
			if(httpClient != null){
				httpClient.close();
			}
		}
	}

}
