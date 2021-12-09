package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean userbean = new UserBean();
		userbean.setfirstName(firstName);
		userbean.setEmail(email);
		userbean.setPassword(password);
		
			int i = 0;
			UserDao userDao = new UserDao();
			
			i = userDao.insertUser(userbean);
			
			RequestDispatcher rd = null;
			if(i == 1)
			{
				rd = request.getRequestDispatcher("Login.jsp");
			}else {
				rd = request.getRequestDispatcher("Fail.jsp");
			}
			rd.forward(request, response);
	}
}