package com.gmail.stefan.ui.views.login;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author mimarko
 *
 */
public class AppUser extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = -9001748565287936168L;
	
	protected String password;
	protected String email; // this is primary username
	protected LocalDateTime lastLogin;
	protected String lastLoginIpv4;
	
	protected LocalDateTime changedOn;
	protected LocalDateTime passwordResetExpireOn;
	protected boolean emailVerified;

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}


	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}


	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String getLastLoginIpv4() {
		return lastLoginIpv4;
	}

	public void setLastLoginIpv4(String lastLoginIpv4) {
		this.lastLoginIpv4 = lastLoginIpv4;
	}


	public LocalDateTime getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(LocalDateTime changedOn) {
		this.changedOn = changedOn;
	}
	
	public LocalDateTime getPasswordResetExpireOn() {
		return passwordResetExpireOn;
	}

	public void setPasswordResetExpireOn(LocalDateTime passwordResetExpireOn) {
		this.passwordResetExpireOn = passwordResetExpireOn;
	}
	
	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((changedOn == null) ? 0 : changedOn.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (emailVerified ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordResetExpireOn == null) ? 0 : passwordResetExpireOn.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (changedOn == null) {
			if (other.changedOn != null)
				return false;
		} else if (!changedOn.equals(other.changedOn))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailVerified != other.emailVerified)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordResetExpireOn == null) {
			if (other.passwordResetExpireOn != null)
				return false;
		} else if (!passwordResetExpireOn.equals(other.passwordResetExpireOn))
			return false;
		
		return true;
	}

	

}