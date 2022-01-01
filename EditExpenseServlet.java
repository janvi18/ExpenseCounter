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

@WebServlet("/EditExpenseServlet") 
public class EditExpenseServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int expenseId = Integer.parseInt(request.getParameter("expenseId"));
		ExpenseDao edao = new ExpenseDao();

		ResultSet ebean = edao.getExpenseById(expenseId);
		System.out.println(ebean);
		request.setAttribute("ebean",ebean);	
		RequestDispatcher rd = request.getRequestDispatcher("EditExpense.jsp");
		rd.forward(request,response);
	}
}
