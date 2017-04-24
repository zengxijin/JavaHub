package com.jack.design.pattern.proxy.jdk;

public class SubjectInvocationHandlerDemo {

	public static void main(String[] args) {
		SubjectInvocationHandler handler = new SubjectInvocationHandler();
		ActionImpl delegate = new ActionImpl();
		Action action = (Action)handler.bindDelegate(delegate);
		action.sayHello("zengxijin");
		action.sayGoodBye("koko");
	}

}
