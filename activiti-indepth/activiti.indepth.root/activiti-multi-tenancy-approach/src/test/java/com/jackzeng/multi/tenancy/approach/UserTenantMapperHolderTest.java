package com.jackzeng.multi.tenancy.approach;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.jackzeng.multi.tenancy.approach.cfg.UserTenantMapperHolder;

public class UserTenantMapperHolderTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("user.tenant.cfg.xml");
		UserTenantMapperHolder holder = (UserTenantMapperHolder)context.getBean("userTenantMapperHolder");
		
		Assert.notNull(holder);
		System.out.println(holder.getUserTenantMapperInfo().toString());
		
		//Assert.notNull(holder.testThreadLocal);
		//System.out.println(holder.testThreadLocal.toString());
		
	}
}
