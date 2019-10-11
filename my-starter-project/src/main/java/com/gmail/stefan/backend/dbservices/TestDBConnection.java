package com.gmail.stefan.backend.dbservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDBConnection {
	 
	public static void main (String[] args) throws SQLException {
			System.out.println("Connecting...");
			
		 	String query = "select firstname from author where id=28";
//		 	String query = "insert into author values (32, 'Abraham', '2019-01-14 10:45:51')";
			
			Connection con = DriverManager.getConnection("jdbc:mysql://46.4.55.195:3306/todo?serverTimezone=UTC#", "root", "komkom");
			System.out.println("Connection succsessful!");
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
//			int count = st.executeUpdate(query);
			
			String name = "";
			
			while(rs.next()) {
				
			
			name = rs.getString("firstname");
			System.out.println("Retrieved user name is: " + name);
			}
//			System.out.println(count + " row/s affected");
			
			st.close();
			con.close();
			System.out.println("Connection closed. ");
	}
	
	
}


