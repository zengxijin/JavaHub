package com.mule.spring.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class AuditStatus {
	public int code;
	public String message;
	public Map<String,Object> data;
	
//	AuditStatus status = new AuditStatus();
//	status.code = 20000;
//	status.message = "OK";
//	status.data = new HashMap<String,Object>();
//	status.data.put("loanno", "123456789");
//	status.data.put("status", "WAIT_REUPLOAD");
//	status.data.put("statusDate", 13465464);
//	status.data.put("message", "OK");
//	status.data.put("externalId", "65464466");
//	
//	List<Map> extra = new ArrayList<Map>();
//	extra.add(getMap("reason",""));
//	extra.add(getMap("idcard_front","reupload"));
//	extra.add(getMap("idcard_back","reupload"));
//	extra.add(getMap("addr_proof","reupload"));
//	status.data.put("extra", extra);
//	
//	System.out.println(JSONObject.toJSONString(status));
}
