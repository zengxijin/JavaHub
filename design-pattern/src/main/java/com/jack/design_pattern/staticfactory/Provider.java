package com.jack.design_pattern.staticfactory;

/**
 * @ClassName: Provider
 * @author:  Jack Zeng 
 * @CreateDate: [2016年8月26日 下午2:35:38]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年8月26日 下午2:35:38]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */
public interface Provider {
	Service newService();
}
