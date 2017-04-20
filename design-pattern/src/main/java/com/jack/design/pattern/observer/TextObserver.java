package com.jack.design.pattern.observer;

public class TextObserver extends Observer {
	
	public TextObserver(Subject subject){
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println("TextObserver " + this.subject.getState() + " update");
	}

}
