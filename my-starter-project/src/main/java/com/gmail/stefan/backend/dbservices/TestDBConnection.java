package com.gmail.stefan.backend.dbservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {

	
	
	public static Connection getConnection() throws SQLException   {
		
		
//		 	String query = "insert into author values (32, 'Abraham', '2019-01-14 10:45:51')";
		System.out.println("Connecting...");
		Connection con = DriverManager.getConnection("jdbc:mysql://46.4.55.195:3306/todo?useUnicode=true&amp;characterEncoding=utf8?autoReconnect=true&useSSL=false", "root", "komkom");
		System.out.println("Connection succsessful!");
																										//			 added ?autoReconnect=true&useSSL=false 
//			System.out.println(count + " row/s affected");

//		st.close();
//		con.close();
		System.out.println("Connection still open. ");
		
		return con;

	}
}
