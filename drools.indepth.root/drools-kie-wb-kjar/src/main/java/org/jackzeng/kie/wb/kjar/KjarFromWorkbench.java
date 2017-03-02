package org.jackzeng.kie.wb.kjar;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.qf.RiskPrice;

/**
 * @ClassName: KjarFromWorkbench
 * @author:  Jack Zeng 
 * @CreateDate: [2017年3月2日 上午10:10:26]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2017年3月2日 上午10:10:26]   
 * @UpdateRemark: [演示从kie-workbench通过maven的加载jar包使用和测试]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */
public class KjarFromWorkbench {

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
            session.insert(riskPrice);  
            session.fireAllRules();
            
            System.out.println(riskPrice.getInterestRate());
            
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {  
            session.dispose();  
        }  
	}

}
