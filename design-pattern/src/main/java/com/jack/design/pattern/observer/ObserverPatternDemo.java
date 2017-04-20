package com.jack.design.pattern.observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		Subject subject = new Subject();
		new BinaryObserver(subject);
		new TextObserver(subject);
		
		subject.setState("start");
		subject.notifyAllObserver();
		
		subject.setState("finished");
		subject.notifyAllObserver();
	}

}
