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


@WebServlet("/ListCategoryServlet")
public class ListCategoryServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDao catDao = new CategoryDao();
		ResultSet rs = catDao.getCategory();
		request.setAttribute("rs", rs);
		RequestDispatcher rd = request.getRequestDispatcher("ListCategory.jsp");
		rd.forward(request, response);
		}
	}
