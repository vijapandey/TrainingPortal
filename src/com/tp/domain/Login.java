package com.tp.domain;

import java.io.Serializable;

public class Login implements Serializable{

	private String emailID;
	
	private String password;
	
	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsTrainer() {
		return isTrainer;
	}

	public void setIsTrainer(Boolean isTrainer) {
		this.isTrainer = isTrainer;
	}

	private Boolean isTrainer;

	@Override
	public String toString() {
		return "Login [emailID=" + emailID + ", password=" + password
				+ ", isTrainer=" + isTrainer + "]";
	}
	
	
	
	
}
