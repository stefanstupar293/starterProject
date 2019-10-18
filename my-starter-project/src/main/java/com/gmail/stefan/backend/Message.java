package com.gmail.stefan.backend;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4304867185183894126L;
	private Long mId = null;
	private String content = "";
	private Date addedon;
	private Long authorid= null;
	private String authorname = "";
	
	public Message(Long id2, String content, Date date, Long authorid, String authorname) {
		this.mId = id2;
		this.content = content;
		this.addedon = date;
		this.authorid = authorid;
		this.authorname = authorname;
		
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		this.mId = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddedon() {
		return addedon;
	}

	public void setAddedon(Date addedon) {
		this.addedon = addedon;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	
}