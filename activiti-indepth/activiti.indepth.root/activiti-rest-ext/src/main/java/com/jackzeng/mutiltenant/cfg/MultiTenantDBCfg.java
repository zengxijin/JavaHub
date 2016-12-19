package com.jackzeng.mutiltenant.cfg;

public class MultiTenantDBCfg {
	private String jdbcUrl;
	private String jdbcUser;
	private String jdbcPassword;
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getJdbcUser() {
		return jdbcUser;
	}
	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
	public String toString(){
		return "{jdbcUrl:" + this.jdbcUrl + " jdbcUser:" + this.jdbcUser + " jdbcPassword:" + this.jdbcPassword + "}";
	}
}
