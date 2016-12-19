package mutiltenant.test;


import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.jackzeng.bpm.deployment.request.DeployRequest;

public class DeployRequestTest {
	@Test
	public void test(){
		String json = "{\"name\":\"xxResourceName\",\"resourceId\":\"xxResourceID\",\"type\":\"xml\",\"userId\":\"tenantABCUser\",\"tenantId\":\"tenantABCId\",\"schema\":\"tenantABC\"}";
		DeployRequest obj = JSONObject.parseObject(json, DeployRequest.class);
		System.out.println(obj.getResourceId());
	}

}
