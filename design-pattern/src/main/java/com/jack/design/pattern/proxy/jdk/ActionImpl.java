package com.jack.design.pattern.proxy.jdk;

public class ActionImpl implements Action {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);

	}

	@Override
	public void sayGoodBye(String name) {
		System.out.println("Good bye " + name);
	}

}
