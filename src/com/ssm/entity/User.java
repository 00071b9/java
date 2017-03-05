package com.ssm.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private Integer id;
	/*@NotEmpty(message="用户名不能为空！")*/
	@NotEmpty(message="{userName.not.empty}")
	private String userName;
	/*@Length(max=11,min=6,message="密码在6-11位之间！")*/
	@Length(max=11,min=6,message="{password.length.error}")
	private String password;
	private String address;
	private Date birthday;
	
	private String phoneNumber;
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, String address, Date birthday, String phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}
	
	public User(Integer id, String userName, String password, String address, Date birthday, String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", address=" + address + ", birthday="
				+ birthday + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
