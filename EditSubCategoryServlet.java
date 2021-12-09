package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/EditSubCategoryServlet")
public class EditSubCategoryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		SubCategoryDao scatdao = new SubCategoryDao();

		SubCategoryBean scb = scatdao.getCategoryById(categoryId);
		System.out.println(scb);
		request.setAttribute("scb",scb);	
		RequestDispatcher rd = request.getRequestDispatcher("EditSubCategory.jsp");
		rd.forward(request,response);
	}
}