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
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>
	<h2>List Category</h2>
	
	<a href="">List Category</a>
	<table border="1">
		<tr>
			<th>CategoryId</th>
			<th>CategoryName</th>
			<th>SubCategoryName</th>
			<th>Expense</th>
			<th>Action</th>
		</tr>
		<%
			while (rs.next()) {
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");
				String subCategoryName = rs.getString("subcategoryName");
				String expense = rs.getString("expense");
		%>
		<tr>
			<td><%=categoryId%></td>
			<td><%=categoryName%></td>
			<td><%=subCategoryName%></td>
			<td><%=expense%></td>
			<td><a href="DeleteCategoryServlet?UserId=<%=categoryId%>">Delete</a>
			    <a href="ViewCategoryServlet?UserId=<%=categoryId%>">View</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>