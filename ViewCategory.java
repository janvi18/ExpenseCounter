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

@WebServlet("/ViewUserServlet")

public class ViewCategory extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int CategoryId = Integer.parseInt(request.getParameter("CategoryId"));
		CategoryDao catDao = new CategoryDao();

		ResultSet rs = catDao.getCategoryById(CategoryId);
		request.setAttribute("rs", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListCategory.jsp"); 
		
		rd.forward(request, response);
		
	}

}