package org.jackzeng.kie.constant;

public enum ResponseCode {
    NORMAL(20000),
    INVALID_PARAMETER(40001),
    RESOURCES_NOT_EXISTS(40004),
    INTERNAL_ERROR(40004);
	
	private int code;
	
	ResponseCode(int code){
		this.setCode(code);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
