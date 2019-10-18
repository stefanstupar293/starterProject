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
import com.gmail.stefan.backend.Message;
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
	
	public static List<Message> selectAllMessages() throws SQLException{
		
		try { 
			Connection con = TestDBConnection.getConnection();
			String query2 = "select * from message";
			Statement st2 = null;
			st2= con.createStatement();
			ResultSet rs2 = st2.executeQuery(query2);
			
//			int id2; 
//			String content; 
//			Timestamp addedon;
//			int aId; 
//			String aname;
			
			List<Message> list2 = new ArrayList<>();
			
		while (rs2.next()) {
		
			int id2 = rs2.getInt(0); 	// conversions
			long mId = (long) id2;
			
			String content = rs2.getString("content");	
			
			Timestamp addedon = rs2.getTimestamp(2);								// check sql table
			Date date = new Date (addedon.getTime());		
			
			int aId = rs2.getInt(3);			
			long authorid = (long) aId;
			
			String authorname = rs2.getString("authorname");
			
			
			
			Message c = new Message(mId, content, date, authorid, authorname);
			list2.add(c);
			System.out.println(mId+' '+content+' '+date+' '+authorid+' '+authorname);
		}
		st2.close();
		con.close();
		return list2;
			
		} catch (SQLException s){
			s.printStackTrace();
		}
		
		return new ArrayList<Message>();
		
	

	
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
