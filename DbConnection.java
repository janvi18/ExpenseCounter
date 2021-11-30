package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static void main(String[] args) {
		DbConnection.openConnection();
	}

	public static Connection openConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/advjava";
		String userName = "root";
		String password = "root";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("EX => " + e.getMessage());
		}
		if (con == null) {
			System.out.println("db not connected");
		} else {
			System.out.println("db connected");
		}

		return con;
	}
}