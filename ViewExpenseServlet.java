package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;
import com.dao.ExpenseDao;

@WebServlet ("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		ExpenseDao eDao = new ExpenseDao();
		
		ResultSet rs = eDao.getCategoryById(categoryId);
		request.setAttribute("rs", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewExpense.jsp");
		rd.forward(request, response);	

		}
	

}
