package helloworld;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;


public class TestEnum {

	public static void main(String[] args) {
		TestEnum.CreditResult cr = new CreditResult();
		cr.setCreditResult(true);
		cr.getHitRules().add(Rule.Q_O001);
		
		String json = JSONObject.toJSONString(cr);
		System.out.println(json);
		
	}
	
    static class CreditResult {
    	
    	public CreditResult(){
    		this.hitRules = new ArrayList<TestEnum.Rule>();
    	}

		/**
	     * 审核结果
	     */
	    private boolean creditResult;

	    /**
	     * 触碰的规则
	     */
	    
		private List<Rule> hitRules;

		public boolean isCreditResult() {
			return creditResult;
		}

		public void setCreditResult(boolean creditResult) {
			this.creditResult = creditResult;
		}

		public List<Rule> getHitRules() {
			return hitRules;
		}

		public void setHitRules(List<Rule> hitRules) {
			this.hitRules = hitRules;
		}
	}
	
	static enum Rule {
	    /**
	     * [产品大纲规则]
	     * 申请信息的产品为“Q易借”,申请信息的个人基本信息的“年龄”小于20岁,大于55岁
	     */
	    Q_O001,

	    /**
	     * [重复进件规则]
	     * 申请人重复进件（证件号码相同或手机号相同),前次申请信息的产品为“Q易借”,审核结果为“已放款”,且状态为“未结清”
	     */
	    Q_R001,

	    /**
	     * [重复进件规则]
	     * 申请人重复进件（证件号码相同且姓名相同),,前次申请信息的产品为“Q易借前次审核结果为“已放款”
	     * ,还款状态为“已结清”,且还款历史出现逾期大于等于30天
	     */
	    Q_R002,

	    /**
	     * [重复进件规则]
	     * 同一申请人,前次审核结果为“拒绝”,且前次申请时间距离当前时间小于等于30天
	     */
	    Q_R003
	    ;

	    Rule(){}
	}

}
