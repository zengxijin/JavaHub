package com.jack.design.pattern.commander;

public class RuntimeServiceCommandImpl implements RuntimeServiceCommand {

	@Override
	public void start() {
		System.out.println("RuntimeServiceCommandImpl query");
	}

	@Override
	public void complete() {
		System.out.println("RuntimeServiceCommandImpl complete");
	}
	
}
