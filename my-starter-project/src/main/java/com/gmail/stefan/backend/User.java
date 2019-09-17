package com.gmail.stefan.backend;

import java.io.Serializable;
import java.util.Random;
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6748982484582588907L;
	
		private Long id;
		private String email= "";
		private String fname= "";
		private String lname= "";
		
		
		
		public User() {}
		
		public User(String email, String fname, String lname) {
			super();
			this.id = new Random().nextLong();
			this.email = email;
			this.fname = fname;
			this.lname = lname;
		}
		
		public User(User other) {
//			Objects.requireNonNull(other); 				// NullPointerException fix?
			if(other== null) other = new User();
			this.fname = other.getFname() !=null ? other.getFname() : "";
			this.lname = other.getLname() !=null ? other.getLname() : "";
			this.email = other.getEmail() !=null ? other.getEmail() : "";
		}
		// getters & setters
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getFname() {
			return fname;
		}
		/**
	     * Sets the value of name
	     *
	     * @param fname
	     *            new value of name
	     */
		
		public void setFname(String fname) {
			this.fname = fname;
		}
		
		public String getLname() {
			return lname;
		}
		
		public void setLname(String lname) {
			this.lname = lname;
		}
		
		@Override
	    public String toString() {
	        // Must use getters instead of direct member access,
	        // to make it work with proxy objects generated by the view model
	        return "User{" + getId() + ":" + getFname() + '}';
	    }

}
