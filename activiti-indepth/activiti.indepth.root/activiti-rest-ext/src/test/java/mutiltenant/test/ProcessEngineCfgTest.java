package mutiltenant.test;

import org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProcessEngineCfgTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("crc-mutiltenant-cfg.xml");
		MultiSchemaMultiTenantProcessEngineConfiguration cfg = (MultiSchemaMultiTenantProcessEngineConfiguration)
				context.getBean("processEngineConfiguration");
		System.out.println(cfg.getDatabaseSchemaUpdate());
	}

}
