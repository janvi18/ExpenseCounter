package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubCategoryDao;

@WebServlet("/AddSubCategoryServlet")
public class AddSubCategoryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String subcategoryName = request.getParameter("subcategoryName");
		 	
			SubCategoryDao scatdao = new SubCategoryDao();
			
			int i = scatdao.insertSubCategory(subcategoryName);
			
			RequestDispatcher rd = request.getRequestDispatcher("Dashborad.jsp");
			rd.forward(request, response);
	}	
}