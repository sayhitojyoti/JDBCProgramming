package com.Metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

public class DatabaseMetadataExample {

	private static String url="jdbc:postgresql://localhost:5432/Jspider?user=postgres&password=123";

	public static void main(String[] args) {
		Driver d = new Driver();
		Connection con = null;

		try {
			DriverManager.registerDriver(d);
			con = DriverManager.getConnection(url);
			String sql = "SELECT *from student";
			Statement stm = con.createStatement();
			// DatabaseMetaData
			DatabaseMetaData data = con.getMetaData();
			System.out.println(data.getDatabaseProductName());
			System.out.println(data.getDriverName());
			System.out.println(data.getDriverVersion());
			System.out.println(data.getDatabaseProductVersion());
			// ResultSetMetaData
			ResultSet resultSet = stm.executeQuery(sql);
			ResultSetMetaData Data = resultSet.getMetaData();
			System.out.println(Data.getColumnCount());
			System.out.println(Data.getColumnName(1));
			System.out.println(Data.getTableName(1));
		} catch (SQLException e) {

		} finally {
			try {
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
