package org.jackzeng.kie.wb.kjar;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.qf.RiskPrice;

public class KjarRuleFlow {

	public static void main(String[] args) {
		RiskPrice riskPrice = new  RiskPrice();
		riskPrice.setAmount(22000);
		riskPrice.setLoanTerm(6);
		
		System.out.println(riskPrice.getInterestRate());
		
		KieServices kieServices = KieServices.Factory.get();  
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		//这里的session的参数取配置在kmodule.xml的stateful的值
    	KieSession session = kContainer.newKieSession("desTableStateflu");
        try {  
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("a", riskPrice);
        	//session.insert(riskPrice);
            session.startProcess("desTable.ruleFlowSample");
            //session.fireAllRules();
            
            System.out.println(riskPrice.getInterestRate());
            
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {  
            session.dispose();  
        }
	}

}
