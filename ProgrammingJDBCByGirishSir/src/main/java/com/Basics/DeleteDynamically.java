package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDynamically {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE from student where id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, 7);
			pstm.execute();
			System.out.println("Data deleted successfully.");

			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
