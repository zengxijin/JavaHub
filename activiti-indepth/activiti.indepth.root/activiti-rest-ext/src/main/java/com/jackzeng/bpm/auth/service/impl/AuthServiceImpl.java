package com.jackzeng.bpm.auth.service.impl;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.stereotype.Service;
import com.jackzeng.bpm.auth.service.AuthService;

/**
 * @author XijinZeng
 * 2016-12-05 10:26:36
 * based on activiti LDAP implements
 */
@Service
public class AuthServiceImpl implements AuthService {
	private UserIdentityManager userIdentityManager;

	public boolean checkPassword(String userId, String pwd) {
		if(userIdentityManager == null){
			throw new RuntimeException("userIdentityManager can't be null, no auth service provider founded");
		}
		return userIdentityManager.checkPassword(userId, pwd);
	}
	
	public AuthServiceImpl(UserIdentityManager userIdentityManager){
		this.userIdentityManager = userIdentityManager;
	}
	
	public AuthServiceImpl(){
		
	}
	
	public AuthService setupAuthService(UserIdentityManager userIdentityManager){
		this.userIdentityManager = userIdentityManager;
		return this;
	}
	
	public UserIdentityManager getUserIdentityManager() {
		return userIdentityManager;
	}

	public void setUserIdentityManager(UserIdentityManager userIdentityManager) {
		this.userIdentityManager = userIdentityManager;
	}
	
	public List<Object> findByUserId(String userId) {
		throw new RuntimeException("AuthService doesn't support creating findByUserId now");
	}

	public List<Object> findByGroupId(String groupId) {
		throw new RuntimeException("AuthService doesn't support creating findByGroupId now");
	}
}
