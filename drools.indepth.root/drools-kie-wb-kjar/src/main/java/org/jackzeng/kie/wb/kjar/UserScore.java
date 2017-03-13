package org.jackzeng.kie.wb.kjar;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserScore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> bufferMap = new ConcurrentHashMap<String,String>();

	public Map<String,String> getBufferMap() {
		return bufferMap;
	}

	public void setBufferMap(Map<String,String> bufferMap) {
		this.bufferMap = bufferMap;
	}

}
