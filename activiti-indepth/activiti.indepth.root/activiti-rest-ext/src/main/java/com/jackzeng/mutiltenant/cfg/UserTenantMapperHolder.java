package com.jackzeng.mutiltenant.cfg;

import java.util.List;

public class UserTenantMapperHolder {
	
	private List<UserTenantMapper> userTenantMapperInfo;

	public List<UserTenantMapper> getUserTenantMapperInfo() {
		return userTenantMapperInfo;
	}

	public void setUserTenantMapperInfo(List<UserTenantMapper> userTenantMapperInfo) {
		this.userTenantMapperInfo = userTenantMapperInfo;
	}
}
