package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;

import com.util.DbConnection;

public class UserDao {
	public int insertUser(String FirstName, String email, String password) {
		int i = -1;
		try {
			Connection con = DbConnection.openConnection();
			
			PreparedStatement pstmt = con
			.prepareStatement("insert into user (FirstName,email,password) values (?,?,?)");

			pstmt.setString(1, FirstName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);

			i = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet getAllUser() {
		ResultSet rs = null;
		try {
			Connection con = DbConnection.openConnection();
		
			PreparedStatement pstmt = con.prepareStatement("select * from user");
					rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void deleteUser(int UserId) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user where UserId = ?");
		) {
			pstmt.setInt(1, UserId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateUser(int userId, String firstName, String email, String password) {
		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update user set firstName = ? , firstName = ? ,email= ? where userId = ? ");) {

			pstmt.setString(1, firstName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setInt(4, userId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("user update");
			} else {
				System.out.println("user updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet getUserById(int userId) {
		ResultSet rs = null;
		try {
			Connection con = DbConnection.openConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from user where userId = ?");
			pstmt.setInt(1, userId);
			
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
