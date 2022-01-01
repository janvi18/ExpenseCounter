package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ExpenseDao;

@WebServlet("/UpdateExpenseServlet")
public class UpdateExpenseServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	int expenseId = Integer.parseInt(request.getParameter("expenseId"));
	String EName = request.getParameter("EName");
	String EAmount = request.getParameter("EAmount");
	String Description = request.getParameter("Description");
	ExpenseDao eDao = new ExpenseDao();
	eDao.updateExpense(expenseId,EName,EAmount,Description);	
	response.sendRedirect("ListExpenseServlet"); 
	
}
	
}
