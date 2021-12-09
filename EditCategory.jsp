<%@page import="com.bean.CategoryBean"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Category</title>
</head>
<body>
	<%
	CategoryBean cb = (CategoryBean) request.getAttribute("cb");
	%>
	<form action="UpdateCategoryServlet" method="post">
		CategoryName: <input type="text" name="categoryName"value="<%=cb.getcategoryName()%>" /><br> 
		
		<input type="hidden" name="categoryId"value="<%=cb.getcategoryId()%>" /> 
		<input type="submit"value="Update Category" />
	</form>
</body>
</html>