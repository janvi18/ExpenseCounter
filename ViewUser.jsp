<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User</title>
</head>
<body>
<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		rs.next();  
		int userId = rs.getInt("userId");
		String firstName = rs.getString("firstName");
		String email = rs.getString("email");
		String password = rs.getString("password");
	
	%>
	<h2>View Users</h2>

			<b>UserId</b> :<%=userId%><br>
			<b>FirstName</b> :<%=firstName%><br>
			<b>Email</b> :<%=email%><bR>
			<b>Password</b> :<%=password%><br>
	<a href="ListUserServlet">Back</a>
</body>
</html>