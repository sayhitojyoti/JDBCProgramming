package com.Basics;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDynamicQueries {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT into student values(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, 7);
			pstm.setString(2, "BADAL");
			pstm.setInt(3, 28);
			pstm.setString(4, "MALE");
			pstm.execute();
			System.out.println("Data inserted successfully.");

			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
