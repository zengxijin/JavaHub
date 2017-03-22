package org.jackzeng.kie.cfg;

public class ProCfg{
	
	/**
	 * application-xxx.properties
	 */
	public static final String BIZ_CATEGORY = "kie.biz.category";
	public static final String KIE_SERVER   = "kie.server.";
	public static final String KIE_USER     = "kie.user.";
	public static final String KIE_PASSWORD = "kie.password.";
	
	public static final String KEY_SERVER   = "server";
	public static final String KEY_USER     = "user";
	public static final String KEY_PASSWORD = "password";
	/**
	 * Basic 认证头，不需要每次算一遍，直接一次算好放缓存
	 */
	public static final String KEY_BASICAUTH = "Authorization";
	
}