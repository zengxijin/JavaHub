package org.jackzeng.kie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jackzeng.kie.response.KieServiceResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brmc")
public class KieServiceController {
	
	@RequestMapping(value = "/container/{version}/{ruleBase}", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public KieServiceResponse invokeKieService(
			@PathVariable("version") String version,
			@PathVariable("ruleBase") String ruleBase,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody String message
			){
		
		KieServiceResponse resp = new KieServiceResponse();
		
		
		//todo:
		
		return resp;
	}
}
