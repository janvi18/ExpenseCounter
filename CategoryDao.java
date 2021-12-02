package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class CategoryDao {
	
	public int insertCategory(String categoryName,String subcategoryName,String expense) {
		int i = -1;
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category (categoryName,subcategoryName,expense) values (?,?,?)");
			pstmt.setString(1, categoryName);
			pstmt.setString(2, subcategoryName);
			pstmt.setString(3, expense);
			
			i = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}
			return i;
		}
	
	public ArrayList<CategoryBean> getAllCategory() {

		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from category");
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<CategoryBean> cat = new ArrayList<>();
			
			while (rs.next()) {
				String categoryName = rs.getString("categoryName");
				String subcategoryName = rs.getString("subcategoryName");
				String expense = rs.getString("expense");
				
				CategoryBean catBean = new CategoryBean();
				
				catBean.setcategoryId(rs.getInt("categoryId"));
				catBean.setcategoryName(categoryName);
				catBean.setsubcategoryName(subcategoryName);
				catBean.setexpense(expense);
				
				cat.add(catBean);
				
			}
			rs.close();
			return cat;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteCategory(int categoryId) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from category where categoryId = ?");

		) {
			pstmt.setInt(1, categoryId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getCategoryById(int categoryId) {
		ResultSet rs = null;
		try {
			Connection con = DbConnection.openConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from category where categoryId = ?");
			pstmt.setInt(1, categoryId);
			
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void updateCategory(int categoryId, String subcategoryName,String expense, String categoryName ) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con
						.prepareStatement("Update category set categoryName = ? , subcategoryName = ? ,expense = ? where categoryId = ? ");) {

			pstmt.setString(1, categoryName);
			pstmt.setString(2, subcategoryName);
			pstmt.setString(3, expense);
			pstmt.setInt(4, categoryId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("Category update");
			} else {
				System.out.println("Category updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}