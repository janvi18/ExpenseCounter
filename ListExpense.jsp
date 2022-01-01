<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Expense</title>
</head>
<body>
	<%
	ArrayList<ExpenseBean> ebean = (ArrayList<ExpenseBean>) request.getAttribute("ebean");
	%>
	<h2>List Expenses</h2>
	<br>
	<table border="1">
		<tr>
			<th>ExpenseId</th>
			<th>CategoryId</th>
			<th>SubCategoryId</th>
			<th>Date</th>
			<th>EName</th>
			<th>EAmount</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<%
		for (int i = 0; i < ebean.size(); i++) {
		%>
		<tr>
			<td><%=ebean.get(i).getExpenseId() %></td>
			<td><%=ebean.get(i).getCategoryId()%></td>
			<td><%=ebean.get(i).getSubCategoryId()%></td>
			<td><%=ebean.get(i).getDate()%></td>
			<td><%=ebean.get(i).getEName()%></td>
			<td><%=ebean.get(i).getEAmount()%></td>
			<td><%=ebean.get(i).getDescription()%></td>
			
				<td><a href="DeleteExpenseServlet?ExpenseId=<%=ebean.get(i).getExpenseId() %>">Delete</a>
				|| <a href="ViewExpenseServlet?ExpenseId=<%=ebean.get(i).getExpenseId() %>">View</a>
			</td>
		</tr>

		<%
		}
		%>
	</table>

</body>
</html>