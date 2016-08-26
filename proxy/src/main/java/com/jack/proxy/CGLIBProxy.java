package com.jack.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * @ClassName: CGLIBProxy
 * @author:  Jack Zeng 
 * @CreateDate: [2016年8月4日 上午10:04:03]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年8月4日 上午10:04:03]   
 * @UpdateRemark: [TODO()]
 * @Description:  [CGLIB]
 * @version: [V1.0]
 */
public class CGLIBProxy implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
