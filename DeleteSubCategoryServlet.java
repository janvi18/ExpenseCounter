package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubCategoryDao;

@WebServlet("/DeleteSubCategoryServlet")
public class DeleteSubCategoryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int CategoryId = Integer.parseInt(request.getParameter("categoryId"));

		SubCategoryDao scatDao = new SubCategoryDao();
		scatDao.deleteSubCategory(CategoryId);

		RequestDispatcher rd = request.getRequestDispatcher("ListSubCategoryServlet");
		rd.forward(request, response);

}
}