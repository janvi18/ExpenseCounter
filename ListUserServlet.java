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

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		ResultSet rs = userDao.getAllUser();
		request.setAttribute("rs", rs);
		RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp");
		rd.forward(request, response);
		}
	}