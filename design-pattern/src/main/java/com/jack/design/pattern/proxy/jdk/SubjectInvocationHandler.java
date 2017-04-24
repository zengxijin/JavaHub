package com.jack.design.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectInvocationHandler implements InvocationHandler {

	private Object delegate = null;
	
	public Object bindDelegate(Object delegate){
		this.delegate = delegate;
		return Proxy.newProxyInstance(
				this.delegate.getClass().getClassLoader(),
				this.delegate.getClass().getInterfaces(),
				this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		
		System.out.println("proxy class:" + this.delegate.getClass().getName());
		result = method.invoke(this.delegate, args);
		
		return result;
	}

}
