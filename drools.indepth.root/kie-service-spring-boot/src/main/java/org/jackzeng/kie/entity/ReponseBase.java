package org.jackzeng.kie.entity;

import java.io.Serializable;

public class ReponseBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int code = 20000;
	private String message = "";
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
