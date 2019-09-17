package com.gmail.stefan.ui.views.login;

import java.io.Serializable;

public class Credentials implements Serializable {
	
	private static final long serialVersionUID = -7286152534299621879L;

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
	
	

}
