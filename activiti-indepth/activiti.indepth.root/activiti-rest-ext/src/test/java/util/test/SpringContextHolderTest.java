package util.test;

import org.junit.Test;
import org.springframework.util.Assert;

import com.jackzeng.bpm.auth.ldap.LDAPQueryConfig;
import com.jackzeng.util.SpringContextHolder;

public class SpringContextHolderTest {
	@Test
	public void test() {
		LDAPQueryConfig ladpCfg = (LDAPQueryConfig)SpringContextHolder.
				getApplicationContext().getBean("ldapQueryConfig");
		
		//Assert.notNull(ladpCfg);
		System.out.println(ladpCfg.getUserIdQuery());
	}

}
