package com.gmail.stefan.ui.views.login;

import java.io.Serializable;

public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4246399630637569782L;

	private String email;
	
	private String password;

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
	
	public boolean Login (String email, String password) {
		if (email.equals("admin@mno.com") && password.equals("admin")) {
			return true;
		}
		return false;
	}
}