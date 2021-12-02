package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {
	
	public void insertUser(UserBean userbean) {
	try {
		Connection con = DbConnection.openConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into user (firstName,email,password) values (?,?,?)");
		pstmt.setString(1, userbean.getfirstName());
		pstmt.setString(2, userbean.getEmail());
		pstmt.setString(3, userbean.getPassword());
		
	int i = pstmt.executeUpdate();
	}catch(Exception e) {
			e.printStackTrace();
		
	}
	}
	
	public ArrayList<UserBean> getAllUser() {
	
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user");
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<UserBean> users = new ArrayList<>();
			

			while (rs.next()) {
				
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");
				String password= rs.getString("password");
				
				UserBean userBean = new UserBean();
				
				userBean.setUserId(rs.getInt("UserId"));
				userBean.setfirstName(firstName);
				userBean.setEmail(email);
				userBean.setPassword(password);
				
				users.add(userBean);
				
			}
			rs.close();
			return users;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteUser(int userId) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user where userId = ?");

		) {

			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

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
	
	public void updateUser(int userId,String firstName,String email,String password) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update user set firstName = ?, email = ? , password = ? where userId = ? ");) {

			pstmt.setString(1, firstName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setInt(4, userId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("User Updated");
			} else {
				System.out.println("User updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ResultSet getUserByName(String firstName) {

		ResultSet rs = null;
		try {

			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user where firstName like ?");
			pstmt.setString(1, firstName);

			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}