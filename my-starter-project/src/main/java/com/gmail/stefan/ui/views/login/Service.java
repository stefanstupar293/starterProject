package com.gmail.stefan.ui.views.login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gmail.stefan.backend.Author;
import com.gmail.stefan.backend.dbservices.TestDBConnection;

public class Service extends TestDBConnection{																// Test DB ?
																											// TODO should assemble and return list of authors 
	public static List<Author> selectAllAuthors() throws SQLException {

		// TODO Auto-generated method stub

		try {
			Connection con = TestDBConnection.getConnection();
			String query = "select firstname from author";
			Statement st = null;
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			List<Author> list = new ArrayList<>();

			while (rs.next()) {
				String name = "";
				name = rs.getString("firstname");
				Author a = new Author(null, name, null);
				System.out.println(name);
				
//				int id;
//				String name = "";
//				Timestamp createdon = null;
//				
//
//				id = rs.getInt(1);
//				long uId = (long) id;
//
//				name = rs.getString("firstname");
//
//				createdon = rs.getTimestamp(3);
//				Date date = new Date(createdon.getTime());
//
//				Author a = new Author(uId, name, date);
//				list.add(a);
//				System.out.println(uId + " " + name + "   " + createdon);
			

			}
			
			st.close();
			con.close();
			System.out.println("Connection closed!");
			
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// cannot return null
		return new ArrayList<Author>();
	}

	
}


//String query = "select * from author";
//Statement st = con.createStatement();
//
//ResultSet rs = st.executeQuery(query);
////	int count = st.executeUpdate(query);
//
//int id;
//String name = "";
//Timestamp createdon = null;
//List<Author> list = new ArrayList<>();
//
//while (rs.next()) {
//
//	id = rs.getInt(1);
//	long uId = (long) id;
//	
//	name = rs.getString("firstname");
//	
//	createdon = rs.getTimestamp(3);
//	Date date =new Date (createdon.getTime());
//	
////	Author a = new Author(); 										// for update row/s
////	a.setId(id);
////	a.setDate(createdon);
////	a.setName(name);
//	
//	Author a = new Author (uId, name, date);
//	list.add(a);
//	System.out.println(uId + " " + name + "   " + createdon);
