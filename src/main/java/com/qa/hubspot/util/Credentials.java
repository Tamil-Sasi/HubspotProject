package com.qa.hubspot.util;

public class Credentials {
	String appUserName;
	String appPassword;
	
	public Credentials(String username,String password){
		this.appUserName = username;
		this.appPassword = password;
	}

	public String getAppUserName() {
		return appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getAppPassword() {
		return appPassword;
	}

	public void setPassword(String password) {
		this.appPassword = password;
	}
	
	

}
