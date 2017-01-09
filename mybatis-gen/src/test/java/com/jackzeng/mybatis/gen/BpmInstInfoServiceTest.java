package com.jackzeng.mybatis.gen;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.jackzeng.mybatis.gen.entity.BpmInstInfo;
import com.jackzeng.mybatis.gen.service.BpmInstInfoService;
import com.jackzeng.mybatis.gen.util.UUIDHelper;


public class BpmInstInfoServiceTest {
	@Test
	public void insertTest(){
		BpmInstInfo bpmInstInfo =  new BpmInstInfo();
		bpmInstInfo.setTransaction_no(UUIDHelper.getUUID());
		bpmInstInfo.setProcess_inst_id(1051L);
		bpmInstInfo.setProcess_status("active");
		bpmInstInfo.setCreated_by("jackzeng");
		bpmInstInfo.setCreated_date(new Date());
		
		BpmInstInfoService service = new BpmInstInfoService();
		Assert.assertTrue(service.insert(bpmInstInfo) > 0);
	}
}
