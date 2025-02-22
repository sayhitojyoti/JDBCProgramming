package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

public class ExecuteQueryUsingDriverManagerref {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider?user=postgres&password=123";
//	private static String userName = "postgres";
//	private static String password = "123";

	public static void main(String[] args) {
		Driver d = new Driver();

		try {
			DriverManager.registerDriver(d);
//			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			String sql = "SELECT *from student";
			ResultSet resultSet = stm.executeQuery(sql);

			while (resultSet.next()) {
				System.out.print("id is:" + resultSet.getInt(1));
				System.out.print("Name is:" + resultSet.getString(2));
				System.out.print("Age is:" + resultSet.getInt(3));
				System.out.print("Gender is:" + resultSet.getString(4));
			}
			con.close();
		}
//		catch (ClassNotFoundException e) {

//		} 
		catch (SQLException e) {

		}
	}
}
