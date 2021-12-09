<%@page import="com.bean.SubCategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub-Category</title>
</head>
<body>
<%
		ArrayList<SubCategoryBean> scat = (ArrayList<SubCategoryBean>) request.getAttribute("scat");
	%>
	<h2>List Sub-Category</h2>
	
	<table border="1">
		<tr>
			<th>CategoryId</th>
			<th>Sub-CategoryName</th>
		 
			<th>Action</th>
		</tr>
		<%
			for (int i = 0; i < scat.size(); i++) {
		%>
		<tr>
			<td><%=scat.get(i).getCategoryId() %></td>
			<td><%=scat.get(i).getSubcategoryName()%></td>
			 
			<td><a href="DeleteSubCategoryServlet?categoryId=<%=scat.get(i).getCategoryId()%>">Delete</a>
			<a href="EditSubCategoryServlet?categoryId=<%=scat.get(i).getCategoryId()%>">Edit</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>