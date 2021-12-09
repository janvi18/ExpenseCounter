package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.SubCategoryBean;
import com.util.DbConnection;

public class SubCategoryDao {
	
	public int insertSubCategory(String subcategoryName) {
		int i = -1;
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into subcategory (subcategoryName) values (?)");
			pstmt.setString(1, subcategoryName);
			
			i = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
		}
			return i;
		}
		
	public ArrayList<SubCategoryBean> getAllSubCategory() {

		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from subcategory");
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<SubCategoryBean> scat = new ArrayList<>();
			
			while (rs.next()) {
				
				SubCategoryBean scatBean = new SubCategoryBean();
				
				scatBean.setCategoryId(rs.getInt("categoryId"));
				scatBean.setSubcategoryName(rs.getString("subcategoryName"));
				
				scat.add(scatBean);
				
			}
			rs.close();
			return scat;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteSubCategory(int categoryId) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from subcategory where categoryId = ?");

		) {
			pstmt.setInt(1, categoryId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SubCategoryBean getCategoryById(int categoryId) {
		ResultSet rs = null;
		try {
			Connection con = DbConnection.openConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from subcategory where categoryId = ?");
			pstmt.setInt(1, categoryId);
		
			rs = pstmt.executeQuery();

			SubCategoryBean scb = new SubCategoryBean();
			rs.next();
			scb.setCategoryId(rs.getInt("categoryId"));
			scb.setSubcategoryName(rs.getString("subcategoryName"));
			return scb;
		} catch (Exception e) {
			System.out.println("Error.....");
			e.printStackTrace();
		}
		return null;
	}

	public void updateSubCategory(int categoryId, String subcategoryName ) {

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("Update subcategory set subcategoryName = ?  where categoryId = ? ");) {
			pstmt.setString(1, subcategoryName);
			pstmt.setInt(2, categoryId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("Sub-Category update");
			} else {
				System.out.println("Sub-Category updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}