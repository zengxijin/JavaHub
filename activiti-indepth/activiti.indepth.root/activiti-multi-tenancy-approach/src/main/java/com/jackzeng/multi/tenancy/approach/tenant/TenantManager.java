package com.jackzeng.multi.tenancy.approach.tenant;

import java.util.Collection;

import org.activiti.engine.impl.cfg.multitenant.TenantInfoHolder;

/**
 * @ClassName: TenantManager
 * @author:  Jack Zeng 
 * @CreateDate: [2016年12月13日 下午5:14:29]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年12月13日 下午5:14:29]   
 * @UpdateRemark: [TODO()]
 * @Description:  activiti建议，在多租户路由的逻辑，最好由用户去实现此TenantInfoHolder的接口
 *                实现细节的逻辑部分由用户自己实现，官方的测试代码给了一个简易版的基于ThreadLocal实现路由
 *                功能的DummyTenantInfoHolder类
 *                实现的原则是：通过租户的用户userId可以确定到用户所属的租户组TenantId，
 *                因为activiti引擎的TenantAwareDataSource通过TenantId来查找对应的Schema的dataSource
 * @version: [V1.0]
 */
public class TenantManager implements TenantInfoHolder {

	public Collection<String> getAllTenants() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCurrentTenantId(String tenantid) {
		// TODO Auto-generated method stub
		
	}

	public String getCurrentTenantId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clearCurrentTenantId() {
		// TODO Auto-generated method stub
		
	}

}
