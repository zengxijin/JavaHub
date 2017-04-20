package com.jack.design.pattern.observer;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("Binary " + this.subject.getState() + " update");
	}
}
