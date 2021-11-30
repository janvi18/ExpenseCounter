package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String FirstName = request.getParameter("FirstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		UserDao userDao  = new UserDao();
		int i = userDao.insertUser(FirstName, email, password)  ;
		
		RequestDispatcher rd = null;
		if (i == 1) {
			rd = request.getRequestDispatcher("Success.jsp");
		} else {
			rd = request.getRequestDispatcher("Fail.jsp");
		} 

		rd.forward(request, response);

	}
}