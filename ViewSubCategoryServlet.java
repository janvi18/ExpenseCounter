package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/ViewSubCategoryServlet")
public class ViewSubCategoryServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	
	SubCategoryDao scatDao = new SubCategoryDao();
	
	SubCategoryBean rs = scatDao.getCategoryById(categoryId);
	request.setAttribute("rs", rs);
	
	RequestDispatcher rd = request.getRequestDispatcher("ViewSubCategory.jsp");
	rd.forward(request, response);	

	}
}