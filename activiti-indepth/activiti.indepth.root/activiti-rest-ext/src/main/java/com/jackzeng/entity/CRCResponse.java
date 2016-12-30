package com.jackzeng.entity;

import java.io.Serializable;

public class CRCResponse implements Serializable {
	private String status = "200";
	private String msg;
	private String code;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static class CODE {
		public static final String NORMAL             = "20000"; 
		public static final String UNAUTHORIZED       = "30001"; 
		public static final String RESOURCE_NOT_FOUND = "40004";
		public static final String ERROR              = "50000";
	}
}
