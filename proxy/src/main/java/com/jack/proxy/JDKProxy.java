
package com.jack.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @ClassName: JDKProxy
 * @author:  Jack Zeng 
 * @CreateDate: [2016年8月3日 上午11:59:23]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年8月3日 上午11:59:23]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */
public class JDKProxy implements InvocationHandler {

	
	public String testStr = "";
	
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
