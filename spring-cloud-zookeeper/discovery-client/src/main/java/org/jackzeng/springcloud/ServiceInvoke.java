package org.jackzeng.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author xijin.zeng created on 2018/5/12
 */
@RestController
public class ServiceInvoke {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    private final String serviceId = "spring-cloud-zookeeper-client-app";

    @RequestMapping(path = "invoke", method = RequestMethod.GET)
    public String invoke() {
        String tmp = "";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

        if (instances != null && instances.size() > 0) {
            instances.forEach(
                    instance -> {
                        System.out.println(instance.getHost() + ":" + instance.getPort() + " uri:" + instance.getUri());
                    }
            );

            String serviceUrl = instances.get(0).getUri() + "/hi";
            System.out.println("invoke url:" + serviceUrl);
            tmp = restTemplate.getForObject(serviceUrl, String.class);
        }

        return tmp + " return";
    }
}
