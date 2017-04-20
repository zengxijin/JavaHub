package com.jack.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private volatile String state;
	private volatile List<Observer> observers = new ArrayList<Observer>();

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void registerObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notifyAllObserver(){
		for(Observer observer : observers){
			observer.update();
		}
	}
}
