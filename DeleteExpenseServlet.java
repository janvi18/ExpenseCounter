package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ExpenseDao;

@WebServlet("/DeleteExpenseServlet")
	public class DeleteExpenseServlet extends HttpServlet {

		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			int expenseId = Integer.parseInt(request.getParameter("expenseId"));

			ExpenseDao eDao = new ExpenseDao();
			eDao.deleteExpense(expenseId);

			response.sendRedirect("ListExpenseServlet");
		}
}
