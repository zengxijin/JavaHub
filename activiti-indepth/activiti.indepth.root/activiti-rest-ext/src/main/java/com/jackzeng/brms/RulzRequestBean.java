package com.jackzeng.brms;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class RulzRequestBean implements Serializable {
	
	/**rest服务地址*/
	private String restUrl;
	
	/**HTTP方法*/
	private String httpMethod;   
	
	/**url请求参数*/
	private String urlQueryParams;
	
	/**Base64编码后的值*/
	private String bodyParams;
	
	/**请求的HTTP header信息*/
	private String headerParams;
	
	/**是否开启加密*/
	private String isEncrypt;
	
	/**加密算法，通过该算法信息，系统应该提前配置对应解密的秘钥信息*/
	private String encryptAgl;
	
	public String getRestUrl() {
		return restUrl;
	}
	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getUrlQueryParams() {
		return urlQueryParams;
	}
	public void setUrlQueryParams(String urlQueryParams) {
		this.urlQueryParams = urlQueryParams;
	}
	public String getBodyParams() {
		return bodyParams;
	}
	public void setBodyParams(String bodyParams) {
		this.bodyParams = bodyParams;
	}
	public String getHeaderParams() {
		return headerParams;
	}
	public void setHeaderParams(String headerParams) {
		this.headerParams = headerParams;
	}
	public String getIsEncrypt() {
		return isEncrypt;
	}
	public void setIsEncrypt(String isEncrypt) {
		this.isEncrypt = isEncrypt;
	}
	public String getEncryptAgl() {
		return encryptAgl;
	}
	public void setEncryptAgl(String encryptAgl) {
		this.encryptAgl = encryptAgl;
	}
	
	public String getRequestUrlWithUrlParams(){
		if(StringUtils.isBlank(this.urlQueryParams)){
			return this.restUrl;
		}else{
			return this.restUrl + "?" + this.urlQueryParams;
		}
	}
	
}
