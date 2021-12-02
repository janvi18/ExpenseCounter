package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int CategoryId = Integer.parseInt(request.getParameter("categoryId"));

		CategoryDao catDao = new CategoryDao();
		catDao.deleteCategory(CategoryId);

		RequestDispatcher rd = request.getRequestDispatcher("ListCategoryServlet");
		rd.forward(request, response);

}
}