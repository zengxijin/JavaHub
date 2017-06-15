package org.jackzeng.kie;

import com.qf.MyBean;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/6/14.
 */
public class XStreamTest {

    public static void main(String[] args) throws Exception {
        KieServerCfg cfg = new KieServerCfg();
        cfg.setUrl("http://172.29.150.141:10000/kie-server/services/rest/server");
        cfg.setUser("kieserver");
        cfg.setPassword("kieserver");

        XStream stream = new XStream();
        MyBean bean = new MyBean();
        bean.setName("jackzeng");
        bean.setAge(1);

        String payload = stream.xstreamParams(Arrays.<Object>asList(bean));
        System.out.println(payload);

        String res = stream.execute(cfg, "client-test1.1", payload);
        System.out.println(res);
    }
}
