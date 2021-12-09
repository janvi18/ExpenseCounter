package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserBean userBean = new UserBean();	
		userBean.setEmail(email);
		userBean.setPassword(password);
		ResultSet status = UserDao.validate(userBean);
		RequestDispatcher rd= null;
		boolean type = UserDao.User_Type(userBean);
		String name = UserDao.User_name(userBean);
		System.out.println(status);
		if(status==null)
		{
			rd = request.getRequestDispatcher("Fail.jsp");
			
		}
		else {
			rd = request.getRequestDispatcher("Home.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
	
		}
		
		rd.forward(request, response);
		
	}
}