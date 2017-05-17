package org.jackzeng;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XijinZeng on 2017/5/17.
 * 规则测试util
 */
public class KieTestBase {

    private static final KieServices services   = KieServices.Factory.get();
    private static final KieContainer container = services.getKieClasspathContainer();

    public static int runTest(String sessionName, List<Object> objects) throws Exception {
        //激活了多少规则
        int firedRules = 0;

        KieSession session = container.newKieSession(sessionName);
        List<FactHandle> handles = new ArrayList<FactHandle>();

        //插入需要测试的facts
        for (Object o : objects){
            handles.add(session.insert(o));
        }

        try {
            firedRules = session.fireAllRules();
        }catch (Exception ex){
            throw ex;
        }finally {
            //清空插入引擎的数据
            for (FactHandle handle : handles){
                session.delete(handle);
            }
        }

        return firedRules;
    }
}
