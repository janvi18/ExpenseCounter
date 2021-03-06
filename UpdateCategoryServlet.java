package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	String categoryName = request.getParameter("categoryName");
	CategoryDao catDao = new CategoryDao();
	catDao.updateCategory(categoryId,categoryName);	
	response.sendRedirect("ListCategoryServlet"); 
	
}
	
}