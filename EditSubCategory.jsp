<%@page import="com.bean.SubCategoryBean"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Sub-Category</title>
</head>
<body>
	<%
	SubCategoryBean scb = (SubCategoryBean) request.getAttribute("scb");
	%>
	<form action="UpdateSubCategoryServlet" method="post">
		CategoryName: <input type="text" name="subcategoryName"value="<%=scb.getSubcategoryName()%>" /><br> 
		
		<input type="hidden" name="categoryId"value="<%=scb.getCategoryId()%>" /> 
		<input type="submit"value="Update Sub-Category" />
	</form>
</body>
</html>