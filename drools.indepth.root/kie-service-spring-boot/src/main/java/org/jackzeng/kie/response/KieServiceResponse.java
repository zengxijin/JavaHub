package org.jackzeng.kie.response;


import java.util.Map;

import org.jackzeng.kie.entity.ReponseBase;

public class KieServiceResponse extends ReponseBase {

	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> data;
	
	public Map<String,Object> getData() {
		return data;
	}
	public void setData(Map<String,Object> data) {
		this.data = data;
	}
	
}
