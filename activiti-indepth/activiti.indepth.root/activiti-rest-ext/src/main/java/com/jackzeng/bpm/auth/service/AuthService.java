package com.jackzeng.bpm.auth.service;

import java.util.List;

/**
 * @author XijinZeng
 * 2016-12-05 10:25:22
 * based on activiti LDAP auth service API
 */
public interface AuthService {
	boolean checkPassword(String userId,String pwd);
	List<Object> findByUserId(String userId);
	List<Object> findByGroupId(String groupId);
}

