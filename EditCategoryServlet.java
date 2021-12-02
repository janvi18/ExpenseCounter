package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		CategoryDao catdao = new CategoryDao();

		ResultSet rs = catdao.getCategoryById(categoryId);
		request.setAttribute("rs",rs);	
		RequestDispatcher rd = request.getRequestDispatcher("EditCategory.jsp");
		rd.forward(request,response);

	}
}
