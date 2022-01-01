package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.util.DbConnection;

public class CategoryDao {

	public ArrayList<CategoryBean> getAllCategories() {

		ArrayList<CategoryBean> categories = new ArrayList<>();

		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from category");) {

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				CategoryBean cb = new CategoryBean();
				cb.setCategoryId(rs.getInt("categoryid"));
				cb.setCategoryName(rs.getString("categoryname"));

				categories.add(cb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	public void addCategory(String categoryName) {
		try (Connection con = DbConnection.openConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into category (categoryname) values (?)");) {

			pstmt.setString(1, categoryName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}