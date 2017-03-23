package org.jackzeng.kie.util;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CloseableHttpHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(CloseableHttpHelper.class);
	
	public static String postRequest(String url, String requestbody, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		LOGGER.info(CloseableHttpHelper.class + " url=" + url + " requestbody=" + requestbody + " headers="
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
						.setConnectTimeout(connTimeoutSeconds*1000)
						.setSocketTimeout(socketTimeoutSeconds*1000);
				httpPost.setConfig(customReqConf.build());
			}
			//请求body
			StringEntity stringEntity = new StringEntity(requestbody,"UTF-8");
			httpPost.setEntity(stringEntity);
			
			//post request
			response = httpClient.execute(httpPost);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			
			if(response.getStatusLine().getStatusCode() != 200) {
				LOGGER.info("statusCode：" + response.getStatusLine().getStatusCode());
			}
			
			return result;
			
		} catch (Exception e) {
			LOGGER.error("error: " + e);
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
	
	public static String postRequest(String url, String requestbody, Map<String, String> headers) throws Exception{
		return postRequest(url,requestbody,headers,5,60);
	}
}
