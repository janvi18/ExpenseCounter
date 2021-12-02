<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category</title>
</head>
<body>
	<%
		ArrayList<CategoryBean> cat = (ArrayList<CategoryBean>) request.getAttribute("cat");
	%>
	<h2>List Category</h2>
	
	<table border="1">
		<tr>
			<th>CategoryId</th>
			<th>CategoryName</th>
			<th>SubCategoryName</th>
			<th>Expense</th>
			<th>Action</th>
		</tr>
		<%
			for (int i = 0; i < cat.size(); i++) {
		%>
		<tr>
			<td><%=cat.get(i).getcategoryId() %></td>
			<td><%=cat.get(i).getcategoryName()%></td>
			<td><%=cat.get(i).getsubcategoryName()%></td>
			<td><%=cat.get(i).getexpense()%></td>
			<td><a href="DeleteCategoryServlet?categoryId=<%=cat.get(i).getcategoryId()%>">Delete</a>
			<a href="EditCategoryServlet?categoryId=<%=cat.get(i).getcategoryId()%>">Edit</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>