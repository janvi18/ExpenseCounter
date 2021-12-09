package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {
	public int insertUser(UserBean userBean) {
		int i = -1;
		try {
			Connection conn = DbConnection.openConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into user (firstName,email,password) values (?,?,?)");
			System.out.println(userBean.getfirstName()+ " " +userBean.getEmail() + " " + userBean.getPassword());
			pstmt.setString(1, userBean.getfirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public ArrayList<UserBean> getAllUser() {
	
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from advjava.user");
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<UserBean> users = new ArrayList<>();
			

			while (rs.next()) {
				
				String firstName = rs.getString("FirstName");
				String email = rs.getString("email");
				String password= rs.getString("password");
				
				UserBean userBean = new UserBean();
				
				userBean.setUserId(rs.getInt("UserId"));
				userBean.setfirstName(firstName);
				userBean.setEmail(email);
				userBean.setPassword(password);
				
				System.out.println(userBean.getfirstName());
				System.out.println(userBean.getEmail());
				System.out.println(userBean.getPassword());
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
				PreparedStatement pstmt = con.prepareStatement("delete from advjava.user where userId = ?");

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
			
			PreparedStatement pstmt = con.prepareStatement("select * from advjava.user where userId = ?");
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
						.prepareStatement("update advjava.user set firstName = ?, email = ? , password = ? where userId = ? ");) {

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
			PreparedStatement pstmt = con.prepareStatement("select * from advjava.user where firstName like ?");
			pstmt.setString(1, firstName);

			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet validate(UserBean userBean) {
		ResultSet rs = null;
		try {
			Connection conn = DbConnection.openConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=? AND Password=?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static boolean User_Type(UserBean bean) {
		boolean type = false;
		try {
			Connection conn = DbConnection.openConnection();
			PreparedStatement pstmt = conn.prepareStatement("select User_Type from users where email=? AND Password=?");
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				type = rs.getBoolean(1);
				System.out.println(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}

	public static String User_name(UserBean userBean) {
		String name = "";
		try {
			Connection conn = DbConnection.openConnection();
			PreparedStatement pstmt = conn.prepareStatement("select Name from users where email=? AND Password=?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	
}