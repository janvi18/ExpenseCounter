<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form action="AddCategoryServlet">
			Category Name : <input type="text" name="categoryName"><br><br>
			 
			<input type="submit" value="Save Category"/> 
		</form>

</body>
</html>