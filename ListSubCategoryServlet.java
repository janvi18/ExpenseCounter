package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/ListSubCategoryServlet")
public class ListSubCategoryServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SubCategoryDao scatDao = new SubCategoryDao();
		ArrayList<SubCategoryBean> scat = scatDao.getAllSubCategory();
		
		request.setAttribute("scat", scat);
		RequestDispatcher rd = request.getRequestDispatcher("ListSubCategory.jsp");
		rd.forward(request, response);
		}
	}