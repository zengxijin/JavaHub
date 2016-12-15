package com.jackzeng.multi.tenancy.approach.cfg;

import java.util.List;
import java.util.Map;

public class UserTenantMapper {
	private Map<String, List<String>> userTenant;
	private String tenantSchema;

	public String getTenantSchema() {
		return tenantSchema;
	}

	public void setTenantSchema(String tenantSchema) {
		this.tenantSchema = tenantSchema;
	}

	public Map<String, List<String>> getUserTenant() {
		return userTenant;
	}

	public void setUserTenant(Map<String, List<String>> userTenant) {
		this.userTenant = userTenant;
	}

	public String toString() {
		if (userTenant != null) {
			return userTenant.toString() + " " + tenantSchema;
		} else {
			return "null";
		}
	}

	
}
