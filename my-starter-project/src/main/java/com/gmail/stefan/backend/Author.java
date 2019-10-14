package com.gmail.stefan.backend;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;



public class Author implements Serializable {

	/**
	 * 
	 */	
	private static final long serialVersionUID = -5671321950578070091L;
	
	private Long uId = null;
	private String name = "";
	private Date date;
	
	public Author () {}
	
	
	
	public Author(Long id, String name, Date date) {
		super();
		this.uId = id;
		this.name = name;
		this.date = date;
	}



	
	public Long getId() {
		return uId;
	}
	public void setId(Long id) {
		this.uId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	public static Collection<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}