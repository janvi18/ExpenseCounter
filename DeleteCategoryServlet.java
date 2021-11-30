package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

public class DeleteCategoryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("CategoryId"));

		CategoryDao catDao = new CategoryDao();
		catDao.deleteCategory(categoryId);

		RequestDispatcher rd = request.getRequestDispatcher("ListCategoryServlet");
		rd.forward(request, response);

}
}
