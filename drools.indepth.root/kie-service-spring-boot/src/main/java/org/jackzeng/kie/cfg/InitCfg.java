package org.jackzeng.kie.cfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jackzeng.kie.util.BRMCBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;



@Configuration
public class InitCfg {

	@Autowired
	Environment environment;
	
	/**
	 * 初始化配置信息
	 */
	@Bean
	public BRMCServerInfo loadCfg() throws IOException{
		BRMCServerInfo brmcServerInfo = new BRMCServerInfo();
		
		String[] profilrs = environment.getActiveProfiles();
		if( profilrs != null && profilrs.length > 0){
			brmcServerInfo.setActiveCfg(profilrs[0]);
		}
		
		Resource resource    = new ClassPathResource("/application-" + brmcServerInfo.getActiveCfg() + ".properties");
		Properties props     = PropertiesLoaderUtils.loadProperties(resource);
		String categories    = props.getProperty(ProCfg.BIZ_CATEGORY);
		List<String> list    = new ArrayList<String>(Arrays.asList(categories.split(",")));
		
		Map<String,Map<String,String>> buffer = new HashMap<String, Map<String,String>>();
		for(String item : list){
			String key = item;
			Map<String,String> map = new HashMap<String, String>();
			map.put(ProCfg.KEY_SERVER, props.getProperty(ProCfg.KIE_SERVER + key));
			map.put(ProCfg.KEY_USER, props.getProperty(ProCfg.KIE_USER + key));
			map.put(ProCfg.KEY_PASSWORD, props.getProperty(ProCfg.KIE_PASSWORD + key));
			
			/**
			 * Basic 认证头，不需要每次算一遍，直接一次算好放缓存
			 */
			String basicAuth = props.getProperty(ProCfg.KIE_USER + key) + ":" +  props.getProperty(ProCfg.KIE_PASSWORD + key);
			map.put(ProCfg.KEY_BASICAUTH, "Basic " + BRMCBase64.EncodeBase64(basicAuth));
			
			buffer.put(key, map);
		}
		
		brmcServerInfo.setInfoMap(buffer);
		
		return brmcServerInfo;
	}
}
