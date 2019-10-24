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

public class Service extends TestDBConnection{																
																											// TODO should assemble and return list of authors 
	public static List<Author> selectAllAuthors() throws SQLException {

		// TODO Auto-generated method stub

		try {
			Connection con = TestDBConnection.getConnection();
			String query = "select * from author";

			Statement st = null;

			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			List<Author> list = new ArrayList<>();

			while (rs.next()) {
				String name = "";
				name = rs.getString("firstname");
				Author x = new Author(null, name, null);

				System.out.println(name);
				list.add(x);

			}

			st.close();
			con.close();
			System.out.println("First connection closed!");

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// cannot return null
		return new ArrayList<Author>();

	}
	

	
	public static List<Author> selectFromAuthors() throws SQLException {
		try {
			Connection con = TestDBConnection.getConnection();
			String authorQuery = "select * from author"; 
			Statement ast = null;
			ast = con.createStatement();
			ResultSet ars = ast.executeQuery(authorQuery);
			List<Author> aList = new ArrayList<>();
			while (ars.next()) {
				int id; 
				String name = "";
				Timestamp createdon = null;
				
				id = ars.getInt(1);
				long uId = (long) id;
				name = ars.getString(2);
				createdon = ars.getTimestamp(3);
				Date date = new Date(createdon.getTime());
				
				Author b = new Author (uId, name, date);
				System.out.println(uId+" "+name+" "+createdon);
				aList.add(b);
			}
			ast.close();
			con.close();
			System.out.println("Second connection closed");
			
			return aList;
			}
		catch (SQLException s) {
			s.printStackTrace();

		}
		System.out.println("DB unavailable");

		return new ArrayList<Author>();
		
		
	}
	
//	int id;
//	String name = "";
//	Timestamp createdon = null;
//	
//
//	id = rs.getInt(1);
//	long uId = (long) id;
//
//	name = rs.getString("firstname");
//
//	createdon = rs.getTimestamp(3);
//	Date date = new Date(createdon.getTime());
//
//	Author a = new Author(uId, name, date);
//	list.add(a);
//	System.out.println(uId + " " + name + "   " + createdon);
	
	
	
	
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
