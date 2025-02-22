package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSQLQuery {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String sql = "SELECT *from student";
			ResultSet resultSet = stm.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println("id is:" + resultSet.getInt(1));
				System.out.println("Name is:" + resultSet.getString(2));
				System.out.println("Age is:" + resultSet.getInt(3));
				System.out.println("Gender is:" + resultSet.getString(4));
				System.out.println("=================================");

			}

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
