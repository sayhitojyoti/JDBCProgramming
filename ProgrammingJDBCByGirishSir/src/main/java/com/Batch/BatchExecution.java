package com.Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider?user=postgres&password=123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
 
			String sql = "INSERT INTO student values(8, 'JEFF BEZOS', 30, 'MALE')";
			stm.addBatch(sql);
			String sql1 = "UPDATE student SET name = 'ABCD', age = 23, gender = 'MALE' WHERE id = 5";
			stm.addBatch(sql1);

			String sql2 = "DELETE FROM student WHERE id = 13";
			stm.addBatch(sql2);

			stm.executeBatch();
			System.out.println("Batch executed successfully.");
			con.close();

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		} 
	}
}
