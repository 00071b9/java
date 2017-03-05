package com.ssm.entity;

import org.springframework.stereotype.Component;

@Component
public class PhoneNumber {
	private String areaNumber;
	private String telNumber;
	public PhoneNumber() {
		super();
	}
	public PhoneNumber(String areaNumber, String telNumber) {
		super();
		this.areaNumber = areaNumber;
		this.telNumber = telNumber;
	}
	public String getAreaNumber() {
		return areaNumber;
	}
	public void setAreaNumber(String areaNumber) {
		this.areaNumber = areaNumber;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	@Override
	public String toString() {
		return  areaNumber + "-" + telNumber ;
	}
	
}
