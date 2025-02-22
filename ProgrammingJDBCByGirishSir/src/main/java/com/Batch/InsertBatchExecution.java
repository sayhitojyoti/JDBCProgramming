package com.Batch;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBatchExecution {

	private static String url = "jdbc:postgresql://localhost:5432/Jspider?user=postgres&password=123";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			String sql = "INSERT into student values(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, 9);
			pstm.setString(2, "GOUTAM ADANI");
			pstm.setInt(3, 28);
			pstm.setString(4, "MALE");
			pstm.addBatch();
			pstm.executeBatch();
			System.out.println("Data inserted successfully.");

			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}
}
