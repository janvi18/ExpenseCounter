<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Sub Category</title>
</head>
<body>
<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		rs.next();
		int categoryId = rs.getInt("categoryId");
		String subcategoryName = rs.getString("subcategoryName");	
	%>
	<h2>Category</h2>

			<b>CategoryId</b> :<%=categoryId%><br>
			<b>SubCategoryName</b> :<%=subcategoryName%><bR>
			
	<a href="ListSubCategoryServlet">Back</a>
	<br>
	<a href="UpdateSubCategoryServlet?CategoryId=<%=categoryId%>">Update Sub-Category</a>
</body>
</html>