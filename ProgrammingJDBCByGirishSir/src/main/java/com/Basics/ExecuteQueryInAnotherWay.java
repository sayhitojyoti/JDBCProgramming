package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryInAnotherWay {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider?user=postgres&password=123";
//	private static String userName = "postgres";
//	private static String password = "123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			String sql = "SELECT *from student";
			ResultSet resultSet = stm.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println("id is:" + resultSet.getInt(1));
				System.out.println("Name is:" + resultSet.getString(2));
				System.out.println("Age is:" + resultSet.getInt(3));
				System.out.println("Gender is:" + resultSet.getString(4));
				System.out.println("=====================.");
			}
			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
