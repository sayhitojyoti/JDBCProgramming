package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Update {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String sql = "UPDATE student SET name = 'SATRUJIT', age = 23, gender = 'MALE' WHERE id =3";
			stm.execute(sql);
			System.out.println("Data updated successfully.");

			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
