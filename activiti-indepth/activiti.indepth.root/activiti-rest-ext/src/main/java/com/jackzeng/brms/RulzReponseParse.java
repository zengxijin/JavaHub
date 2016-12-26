package com.jackzeng.brms;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class RulzReponseParse {
	public static String dummyParse(String responseJson){
		JSONObject json = JSONObject.parseObject(responseJson);
		JSONArray array = json.getJSONObject("result").getJSONObject("execution-results").getJSONArray("results");
		for(int i=0;i<array.size();i++){
			if( "PaymentBean".equals(array.getJSONObject(i).getString("key")) ){
				String approvalPath = array.getJSONObject(i)
						.getJSONObject("value")
						.getJSONObject("com.smartcrc.demo.rulz.payment.PaymentBean")
						.getString("approvalPath");
				return approvalPath;
			}
		}
		return null;
	}
}
