package org.jackzeng.kie.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.jackzeng.kie.cfg.BRMCRequestCfg;
import org.jackzeng.kie.cfg.KieServiceRawCfg;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 解析和组装kie-server的REST请求参数
 * @ClassName: KieRequestHelper
 * @Author:  Jack Zeng 
 * @CreateDate: [2017-3-23 15:14:28]   
 */

public class KieRequestHelper {
	
	public static JSONObject assembleKieRest(JSONObject json){
		return assembleKieRest(json, false, null, -1);
	}
	
	public static JSONObject assembleKieRest(JSONObject json, long fireMax){
		return assembleKieRest(json, false, null, fireMax);
	}
	
	/**
	 * 返回具有get-objects命令的参数，需要给定returnKey
	 */
	public static JSONObject assembleKieRest(JSONObject json, boolean isGetObjects, String returnKey, long fireMax){
		JSONObject obj = new JSONObject();
		obj.put(KieServiceRawCfg.LOOKUP, json.getString(BRMCRequestCfg.RULE_SESSION));
		
		JSONArray array = new JSONArray();
		JSONArray insert = parseInsert(json);
		JSONObject process = parseStartProcess(json);
		JSONObject query = parseQuery(json);
		JSONObject fireAllRules = parseFireAllRules(fireMax);
		
		if(insert != null){
			for(int i=0;i<insert.size();i++){
				array.add(insert.getJSONObject(i));
			}
		}
		if(process != null){
			array.add(process);
		}
		if(query != null){
			array.add(query);
		}
		
		array.add(fireAllRules);
		
		if(isGetObjects == true){
			JSONObject getObjects = parseGetObjects(returnKey);
			array.add(getObjects);
		}
		
		obj.put(KieServiceRawCfg.COMMANDS, array);
		
		return obj;
	}
	
	/**
	 * 组装insert命令参数
	 */
	public static JSONArray parseInsert(JSONObject json){
		JSONArray array = json.getJSONArray(BRMCRequestCfg.OBJECTS);
		if(array == null || array.size() == 0){
			return null;
		}
		
		JSONArray arrayBuffer = new JSONArray();
		
		for(int i = 0; i < array.size(); i++){
			JSONObject insertCmd = new JSONObject();
			
			JSONObject item = array.getJSONObject(i);
			String returnKey = item.getString(BRMCRequestCfg.RETURN_KEY);
			//如果不为空则表示需要返回对象
			if( StringUtils.isNotBlank(returnKey)){
				insertCmd.put(KieServiceRawCfg.RETURN_OBJECT, true);
				insertCmd.put(KieServiceRawCfg.OUT_IDENTIFIER, returnKey);
			}else{
				insertCmd.put(KieServiceRawCfg.RETURN_OBJECT, false);
			}
			
			//克隆子节点信息，删掉returnKey节点，其它信息原样拷贝
			//如果不克隆的话，会直接修改源节点信息，有隐患
			JSONObject itemCopy = (JSONObject) item.clone();
			itemCopy.remove(BRMCRequestCfg.RETURN_KEY);
			insertCmd.put(KieServiceRawCfg.OBJECT, itemCopy);
			
			JSONObject insert = new JSONObject();
			insert.put(KieServiceRawCfg.INSERT, insertCmd);
			arrayBuffer.add(insert);
		}
		return arrayBuffer;
	}
	
	/**
	 * 组装start-process命令参数
	 */
	public static JSONObject parseStartProcess(JSONObject json){
		JSONObject ruleFlow = json.getJSONObject(BRMCRequestCfg.RULE_FLOW);
		if(ruleFlow == null || ruleFlow.size() == 0){
			return null;
		}
		
		String processId = ruleFlow.getString(BRMCRequestCfg.PROCESS_ID);
		String returnKey = ruleFlow.getString(BRMCRequestCfg.RETURN_KEY);
		
		JSONObject startProcessCmd = new JSONObject();
		startProcessCmd.put(KieServiceRawCfg.PROCESS_ID, processId);
		startProcessCmd.put(KieServiceRawCfg.OUT_IDENTIFIER, returnKey);
		startProcessCmd.put(KieServiceRawCfg.PARAMETERS, ruleFlow.getJSONArray(BRMCRequestCfg.PARAMETERS));
		
		JSONObject buffer = new JSONObject();
		buffer.put(KieServiceRawCfg.START_PROCESS, startProcessCmd);
		
		return buffer;
	}
	
	/**
	 * 组装query命令参数
	 */
	public static JSONObject parseQuery(JSONObject json){
		JSONObject query = json.getJSONObject(BRMCRequestCfg.QUERY);
		if(query == null || query.size() == 0){
			return null;
		}
		
		JSONObject buffer = new JSONObject();
		
		String name = query.getString(BRMCRequestCfg.NAME);
		String returnKey = query.getString(BRMCRequestCfg.RETURN_KEY);
		
		JSONObject queryCmd = new JSONObject();
		queryCmd.put(KieServiceRawCfg.NAME, name);
		queryCmd.put(KieServiceRawCfg.OUT_IDENTIFIER, returnKey);
		
		JSONArray parametes = query.getJSONArray(BRMCRequestCfg.PARAMETERS);
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0; i < parametes.size(); i++){
			Iterator<Entry<String, Object>> it = parametes.getJSONObject(i).entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, Object> entry = it.next();
				map.put(entry.getKey(), entry.getValue());
			}
		}
		JSONObject tmp = new JSONObject();
		tmp.putAll(map);
		queryCmd.put( KieServiceRawCfg.ARGS, tmp );
		
		buffer.put(KieServiceRawCfg.QUERY, queryCmd);
		
		return buffer;
	}
	
	/**
	 * 组装fire-all-rules命令参数
	 */
	public static JSONObject parseFireAllRules(long fireMax){
		JSONObject fire = new JSONObject();
		
		if(fireMax > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put(KieServiceRawCfg.FIRE_RULES_MAX, fireMax);
			map.put(KieServiceRawCfg.OUT_IDENTIFIER, "brmc");
			fire.put(KieServiceRawCfg.FIRE_ALL_RULES, "");
		}
		
		fire.put(KieServiceRawCfg.FIRE_ALL_RULES, "");
		return fire;
	}
	
	/**
	 * 组装get-objects命令参数
	 */
	public static JSONObject parseGetObjects(String outIdentifier){
		JSONObject getObjects = new JSONObject();
		JSONObject outInfo = new JSONObject();
		outInfo.put(KieServiceRawCfg.OUT_IDENTIFIER, outIdentifier);
		getObjects.put(KieServiceRawCfg.GET_OBJECTS, outInfo);
		return getObjects;
	}
	
    public static void parseExtra(JSONObject json){
		
	}
}
