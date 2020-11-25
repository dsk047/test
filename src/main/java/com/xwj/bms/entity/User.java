package com.xwj.bms.entity;

public class User {
	private String userName;
	
	private String userPassword;
	
	private String phoneNumber;
	
	private int day;
	
	private int overdue;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public User(String userName, String userPassword, String phoneNumber, int day, int overdue) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.phoneNumber = phoneNumber;
		this.day = day;
		this.overdue = overdue;
	}

	public User() {
		super();
	}
	
}
