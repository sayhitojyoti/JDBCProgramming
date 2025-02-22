package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String sql = "Insert into student values(5, 'CHANDAN', 25, 'male')";
			stm.execute(sql);
			System.out.println("Data inserted successfully.");
			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
