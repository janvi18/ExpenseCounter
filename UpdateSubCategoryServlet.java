package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubCategoryDao;

@WebServlet("/UpdateSubCategoryServlet")
public class UpdateSubCategoryServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	int subcategoryId = Integer.parseInt(request.getParameter("subcategoryId"));
	String subcategoryName = request.getParameter("subcategoryName");
	SubCategoryDao scatDao = new SubCategoryDao();
	scatDao.updateSubCategory(subcategoryId,subcategoryName);	
	response.sendRedirect("ListSubCategoryServlet"); 
	
	}	
}