package com.gmail.stefan.backend.dbservices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gmail.stefan.backend.Author;

public class TestDBConnection {

	public static void main(String[] args) throws SQLException {
		System.out.println("Connecting...");

		String query = "select * from author";
//		 	String query = "insert into author values (32, 'Abraham', '2019-01-14 10:45:51')";

		Connection con = DriverManager.getConnection("jdbc:mysql://46.4.55.195:3306/todo?serverTimezone=UTC#", "root",
				"komkom");
		System.out.println("Connection succsessful!");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
//			int count = st.executeUpdate(query);

		int id;
		String name = "";
		Timestamp createdon = null;
		List<Author> list = new ArrayList<>();

		while (rs.next()) {

			id = rs.getInt(1);
			long uId = (long) id;
			
			name = rs.getString("firstname");
			
			createdon = rs.getTimestamp(3);
			Date date =new Date (createdon.getTime());
			
//			Author a = new Author(); 										// for update row/s
//			a.setId(id);
//			a.setDate(createdon);
//			a.setName(name);
			
			Author a = new Author (uId, name, date);
			list.add(a);
			System.out.println(uId + " " + name + "   " + createdon);
		}
//			System.out.println(count + " row/s affected");

		st.close();
		con.close();
		System.out.println("Connection closed. ");
	}

}