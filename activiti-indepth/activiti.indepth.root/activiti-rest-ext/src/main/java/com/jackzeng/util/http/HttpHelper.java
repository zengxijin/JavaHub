package com.jackzeng.util.http;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName: HttpHelper
 * @author:  Jack Zeng 
 * @CreateDate: [2016年12月26日 下午7:14:47]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年12月26日 下午7:14:47]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */
public class HttpHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpHelper.class);
	private static final int DEFAULT_CONN_TIMEOUT   = 10*1000;
	private static final int DEFAULT_SOCKET_TIMEOUT = 60*1000;
	
	public static String postRequest(String url, String requestbody, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		LOGGER.info(HttpHelper.class + " url=" + url + " requestbody=" + requestbody + " headers="
				+ headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );
		
		/**DefaultHttpRequestRetryHandler it will try 3-times by default*/
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
		CloseableHttpResponse response = null;
        HttpPost httpPost = null;        
        String   result   = null;
        try {
			httpPost = new HttpPost(url);
			//headers setting
			if ((headers != null) && (headers.isEmpty() == false)) {
				for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
					httpPost.addHeader(entryLoc.getKey(), entryLoc.getValue());
				}
			}
			//connection and socket-timeout settings
			if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
				RequestConfig.Builder customReqConf = RequestConfig.custom()
						.setConnectTimeout(connTimeoutSeconds)
						.setSocketTimeout(socketTimeoutSeconds);
				httpPost.setConfig(customReqConf.build());
			}
			
			//request body setting
			if(StringUtils.isNotBlank(requestbody)){
				StringEntity stringEntity = new StringEntity(requestbody,"UTF-8");
				httpPost.setEntity(stringEntity);
			}
			
			//execute post request
			response = httpClient.execute(httpPost);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			return result;
			
		} catch (Exception e) {
			LOGGER.error("post request error" + e);
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
		return HttpHelper.postRequest(url, requestbody, headers, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
	}
	
	public static String getRequest(String url, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		LOGGER.info(HttpHelper.class + " url=" + url + " headers="
				+ headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );
		
		/**DefaultHttpRequestRetryHandler it will try 3-times by default*/
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
		CloseableHttpResponse response = null;
        HttpGet httpGet = null;        
        String   result   = null;
        try {
        	httpGet = new HttpGet(url);
			//headers setting
			if ((headers != null) && (headers.isEmpty() == false)) {
				for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
					httpGet.addHeader(entryLoc.getKey(), entryLoc.getValue());
				}
			}
			//connection and socket-timeout settings
			if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
				RequestConfig.Builder customReqConf = RequestConfig.custom()
						.setConnectTimeout(connTimeoutSeconds)
						.setSocketTimeout(socketTimeoutSeconds);
				httpGet.setConfig(customReqConf.build());
			}
			
			//execute post request
			response = httpClient.execute(httpGet);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			return result;
			
		} catch (Exception e) {
			LOGGER.error("get request error" + e);
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
	
	public static String getRequest(String url, Map<String, String> headers) throws Exception {
		return getRequest(url,headers,DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
	}
	
	public static String putRequest(String url, String requestbody, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		LOGGER.info(HttpHelper.class + " url=" + url + " requestbody=" + requestbody + " headers="
				+ headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );
		
		/**DefaultHttpRequestRetryHandler it will try 3-times by default*/
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
		CloseableHttpResponse response = null;
        HttpPut httpPut = null;        
        String   result   = null;
        try {
        	httpPut = new HttpPut(url);
			//headers setting
			if ((headers != null) && (headers.isEmpty() == false)) {
				for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
					httpPut.addHeader(entryLoc.getKey(), entryLoc.getValue());
				}
			}
			//connection and socket-timeout settings
			if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
				RequestConfig.Builder customReqConf = RequestConfig.custom()
						.setConnectTimeout(connTimeoutSeconds)
						.setSocketTimeout(socketTimeoutSeconds);
				httpPut.setConfig(customReqConf.build());
			}
			
			//request body setting
			if(StringUtils.isNotBlank(requestbody)){
				StringEntity stringEntity = new StringEntity(requestbody,"UTF-8");
				httpPut.setEntity(stringEntity);
			}
			
			//execute post request
			response = httpClient.execute(httpPut);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			return result;
			
		} catch (Exception e) {
			LOGGER.error("put request error" + e);
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
	
	public static String putRequest(String url, String requestbody, Map<String, String> headers) throws Exception{
		return HttpHelper.putRequest(url, requestbody, headers, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
	}
	
	public static String deleteRequest(String url, Map<String, String> headers,
			int connTimeoutSeconds,int socketTimeoutSeconds) 
			throws Exception{
		
		LOGGER.info(HttpHelper.class + " url=" + url + " headers="
				+ headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );
		
		/**DefaultHttpRequestRetryHandler it will try 3-times by default*/
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
		CloseableHttpResponse response = null;
        HttpDelete httpDelete = null;        
        String   result   = null;
        try {
        	httpDelete = new HttpDelete(url);
			//headers setting
			if ((headers != null) && (headers.isEmpty() == false)) {
				for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
					httpDelete.addHeader(entryLoc.getKey(), entryLoc.getValue());
				}
			}
			//connection and socket-timeout settings
			if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
				RequestConfig.Builder customReqConf = RequestConfig.custom()
						.setConnectTimeout(connTimeoutSeconds)
						.setSocketTimeout(socketTimeoutSeconds);
				httpDelete.setConfig(customReqConf.build());
			}
			
			//execute post request
			response = httpClient.execute(httpDelete);
			
			//get response
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			return result;
			
		} catch (Exception e) {
			LOGGER.error("put request error" + e);
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
	
	public static String deleteRequest(String url, Map<String, String> headers) throws Exception{
		return HttpHelper.deleteRequest(url, headers, DEFAULT_CONN_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
	}
	
}
