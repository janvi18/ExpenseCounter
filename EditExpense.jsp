<%@page import="com.bean.ExpenseBean"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<%
	ExpenseBean eb = (ExpenseBean) request.getAttribute("eb");
	%>
	<form action="UpdateExpenseServlet" method="post">
		CategoryName: <input type="text" name="expenseName"value="<%=eb.getExpenseName()%>" /><br> 
		
		<input type="hidden" name="categoryId"value="<%=eb.getcategoryId()%>" /> 
		<input type="submit"value="Update Expense" />
	</form>
</body>
</html>