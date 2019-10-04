package com.gmail.stefan.ui.views.login;

import java.io.Serializable;

public class Credentials implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4246399630637569782L;

	private String email = "admin@mno.com";
	
	private String password = "admin";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}