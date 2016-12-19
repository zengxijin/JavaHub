package com.jackzeng.bpm.deployment.service;

/**
 * @author XijinZeng
 * CRC activiti流程资源管理接口
 */
public interface CRCResourceManager {
	String getResource(String resourceId);
	byte[] getResourceBinary(String resourceId);
	boolean deleteResource(String resourceId);
}
