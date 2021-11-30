package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/ViewUserServlet")

public class ViewUserServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int UserId = Integer.parseInt(request.getParameter("UserId"));
		UserDao userDao = new UserDao();

		ResultSet rs = userDao.getUserById(UserId);
		request.setAttribute("rs", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp"); 
		
		rd.forward(request, response);
		
	}

}