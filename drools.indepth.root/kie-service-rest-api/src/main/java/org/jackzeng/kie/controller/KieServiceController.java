package org.jackzeng.kie.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
/**
 * @ClassName: KieServiceController
 * @author:  Jack Zeng 
 * @CreateDate: [2017年3月15日 下午2:17:07]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2017年3月15日 下午2:17:07]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */

@RestController
public class KieServiceController {
	
	/**
	 * 调用规则引擎封装的API
	 */
	@RequestMapping(value = "/{version}/brmc/container/{ruleBase}", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	public String ruleBase(@PathVariable("version") String version,@PathVariable("ruleBase") String ruleBase,
			HttpServletRequest request,HttpServletResponse response,@RequestBody String message){
		
		if(StringUtils.isBlank(ruleBase) || StringUtils.isBlank(version)){
			
		}
		Map<String,String> map = new ConcurrentHashMap<String, String>();
		map.put("version", version);
		map.put("ruleBase", ruleBase);
		
		//Todo:service impl
		
		return JSONObject.toJSONString(map);
	}
}
