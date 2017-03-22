package org.jackzeng.kie.cfg;

import java.util.Map;
/**
 * 用于缓存服务器的配置信息application-xxx.properties
 * @ClassName: BRMCServerInfo
 * @Author:  Jack Zeng 
 * @CreateDate: [2017-3-22 10:50:11]   
 */

public class BRMCServerInfo {
	
	private String activeCfg;
	
	private Map<String,Map<String,String>> infoMap;

	public String getActiveCfg() {
		return activeCfg;
	}

	public void setActiveCfg(String activeCfg) {
		this.activeCfg = activeCfg;
	}

	public Map<String, Map<String, String>> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, Map<String, String>> infoMap) {
		this.infoMap = infoMap;
	}
	
	
}
