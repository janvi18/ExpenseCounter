package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;
import com.dao.ExpenseDao;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@WebServlet ("/ListExpenseServlet")
public class ListExpenseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ExpenseDao edao = new ExpenseDao();
		ArrayList<ExpenseBean> ebean = edao.getAllExpense();
		request.setAttribute("ebean", ebean);
		RequestDispatcher rd = request.getRequestDispatcher("ListExpense.jsp");
		rd.forward(request, response);

	}

}
