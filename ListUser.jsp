<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>


	<table border="1">
		<tr>
			<td>UserId</td>
			<td>FirstName</td>
			<td>Email</td>
		</tr>


		<%
			for (UserBean user : users) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getEmail()%></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>