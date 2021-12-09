package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class CategoryDao {
	
	public int insertCategory(String categoryName) {
		int i = -1;
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category (categoryName) values (?)");
			pstmt.setString(1, categoryName);
			
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
				
				CategoryBean catBean = new CategoryBean();
				
				catBean.setcategoryId(rs.getInt("categoryId"));
				catBean.setcategoryName(rs.getString("categoryName"));
				
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
	
	public CategoryBean getCategoryById(int categoryId) {
		ResultSet rs = null;
		try {
			Connection con = DbConnection.openConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from category where categoryId = ?");
			pstmt.setInt(1, categoryId);
		
			rs = pstmt.executeQuery();
			CategoryBean cb = new CategoryBean();
			rs.next();
			cb.setcategoryId(rs.getInt("categoryId"));
			cb.setcategoryName(rs.getString("categoryName"));
			return cb;
		} catch (Exception e) {
			System.out.println("error.....");
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateCategory(int categoryId,   String categoryName ) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con
						.prepareStatement("Update category set categoryName = ?  where categoryId = ? ");) {
			pstmt.setString(1, categoryName);
			pstmt.setInt(2, categoryId);
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