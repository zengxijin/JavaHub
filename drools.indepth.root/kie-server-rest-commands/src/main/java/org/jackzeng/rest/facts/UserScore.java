package org.jackzeng.rest.facts;

import java.io.Serializable;

public class UserScore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ageScore;
	private String auditCode;
	public int getAgeScore() {
		return ageScore;
	}
	public void setAgeScore(int ageScore) {
		this.ageScore = ageScore;
	}
	public String getAuditCode() {
		return auditCode;
	}
	public void setAuditCode(String auditCode) {
		this.auditCode = auditCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UserScore(){
		super();
	}
	
	public UserScore(int ageScore, String auditCode) {
		super();
		this.ageScore = ageScore;
		this.auditCode = auditCode;
	}

}
