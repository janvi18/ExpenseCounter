<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
</head>
<body>
<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>
	<h2>List User</h2>
	
	<a href="">List User</a>
	<br>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
		<%
			while (rs.next()) {
				int UserId = rs.getInt("UserId");
				String FirstName = rs.getString("FirstName");
				String email = rs.getString("email");
				String password = rs.getString("password");
		%>
		<tr>
			<td><%=UserId%></td>
			<td><%=FirstName%></td>
			<td><%=email%></td>
			<td><%=password%></td>
			<td><a href="DeleteUserServlet?UserId=<%=UserId%>">Delete</a>
			    <a href="ViewUserServlet?UserId=<%=UserId%>">View</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>