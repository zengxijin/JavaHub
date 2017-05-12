package com.qf;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class TestRules {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("kie-enum-stateful");
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setStringField("String1");
        wrapper.setEnumField(LoanStatus.NONE);
        kSession.insert(wrapper);
        kSession.fireAllRules();
    }
}
