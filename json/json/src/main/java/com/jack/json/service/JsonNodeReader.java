/**
 * 
 */
package com.jack.json.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: Jack
 * @email: zengxijin@qq.com
 * @version: 1.0
 * @CreateDate: 2016-8-2 16:55:00
 * @Description: support to using the pattern like root.node1.node2
 *               to get JSONObject or JSONArray
 */
public class JsonNodeReader {
	/**
	 * @param  srcJson
	 * @param  nodePath
	 * @return can't find the Object will return null
	 */
	public static JSONObject getJsonObject(JSONObject srcJson,String nodePath) {
		JSONObject retJson = null;
		if (srcJson != null && nodePath != null && nodePath.isEmpty() == false) {
			if (nodePath.contains(".") == false) {
				retJson = srcJson.getJSONObject(nodePath);
			} else {
				String[]   nodes   = nodePath.split("\\.");
				JSONObject tmpJson = srcJson;
				
				for(String node : nodes){
					retJson = tmpJson.getJSONObject(node);
					if(retJson != null){ tmpJson = retJson; }
					else{ break; } //can't find the node,retJson will be null
				}
			}
		}
		return retJson;
	}
	
	/**
	 * @param  srcJson
	 * @param  nodePath
	 * @return can't find the Array will return null
	 */
	public static JSONArray getJsonArray(JSONObject srcJson, String nodePath) {
		JSONArray retJson = null;
		if (srcJson != null && nodePath != null && nodePath.isEmpty() == false) {
			if (nodePath.contains(".") == false) {
				retJson = srcJson.getJSONArray(nodePath);
			} else {
				String[]   nodes   = nodePath.split("\\.");
				JSONObject tmpJson = srcJson;
				JSONObject tmpObj  = null;
				
				for(int i=0; i<nodes.length - 1; i++){
					tmpObj = tmpJson.getJSONObject(nodes[i]);
					if(tmpObj != null){ tmpJson = tmpObj; }
					else{ break; } //can't find the node
				}
				if(tmpObj!=null){  //last node should be Array
					retJson = tmpObj.getJSONArray(nodes[nodes.length-1]);
				}
			}
		}
		return retJson;
	}
}
