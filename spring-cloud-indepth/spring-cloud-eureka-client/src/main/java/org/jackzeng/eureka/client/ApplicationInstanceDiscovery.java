package org.jackzeng.eureka.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class ApplicationInstanceDiscovery {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping(path="/instances/{topic}", produces="application/json;charset=utf-8" )
	public List<InstanceInfo> getInstances(@PathVariable("topic") String topic){
		Application app = eurekaClient.getApplication(topic);
		return app.getInstances();
	}
}
