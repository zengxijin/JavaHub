package org.jackzeng.rest.facts;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String occupation;
	private int age;
	private boolean hasChild;
	private double income;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UserInfo(String name, String occupation, int age, boolean hasChild, double income) {
		super();
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.hasChild = hasChild;
		this.income = income;
	}
	
	public UserInfo() {
		super();
	}
}
