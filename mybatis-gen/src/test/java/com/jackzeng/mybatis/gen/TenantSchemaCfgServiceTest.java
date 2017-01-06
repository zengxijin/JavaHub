package com.jackzeng.mybatis.gen;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.jackzeng.mybatis.gen.entity.TenantSchemaCfg;
import com.jackzeng.mybatis.gen.service.TenantSchemaCfgService;

public class TenantSchemaCfgServiceTest {
	@Test
	public void insertTest(){
		TenantSchemaCfg cfg = new TenantSchemaCfg();
		//cfg.setId(1L);
		cfg.setTenant_id("paydayLoan");
		cfg.setTenant_schema("paydayLoanSchema");
		cfg.setDb_type("mysql");
		cfg.setCreated_by("XijinZeng");
		cfg.setCreated_date(new Date());
		
		TenantSchemaCfgService service = new TenantSchemaCfgService();
		Assert.assertTrue(service.insert(cfg) > 0);
	}
}
