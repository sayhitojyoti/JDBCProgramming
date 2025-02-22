package com.Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdatemethod {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider";
	private static String userName = "postgres";
	private static String password = "123";

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String sql1 = "INSERT INTO student values(17, 'JEFF BEZOS', 30, 'MALE')";
			int a=stm.executeUpdate(sql1);
			System.out.println(a);
			
			con.close();

		
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
