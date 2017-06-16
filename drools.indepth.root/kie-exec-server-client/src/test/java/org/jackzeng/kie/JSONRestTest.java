package org.jackzeng.kie;

import com.qf.MyBean;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/15.
 */
public class JSONRestTest {
    @Test
    public void jsonTest() throws Exception {
        KieServerCfg cfg = new KieServerCfg();
        cfg.setUrl("http://172.29.150.141:10000/kie-server/services/rest/server");
        cfg.setUser("kieserver");
        cfg.setPassword("kieserver");

        MyBean bean = new MyBean();
        bean.setName("jackzeng");
        bean.setAge(1);

        JSONRest rest = new JSONRest(cfg);
        System.out.println(rest.executeCmds("client-test1.1",bean));
    }
}
