package com.jackzeng.bpm.auth.ldap;

public class LDAPQueryConfig {
	private String userIdQuery;
	private String groupQuery;
	
	public String getUserIdQuery() {
		return userIdQuery;
	}
	public void setUserIdQuery(String userIdQuery) {
		this.userIdQuery = userIdQuery;
	}
	public String getGroupQuery() {
		return groupQuery;
	}
	public void setGroupQuery(String groupQuery) {
		this.groupQuery = groupQuery;
	}
}
