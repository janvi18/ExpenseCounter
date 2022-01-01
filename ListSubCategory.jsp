<%@page import="com.bean.SubCategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub-Category</title>
</head>
<body>
<%
		ArrayList<SubCategoryBean> subCategories = (ArrayList<SubCategoryBean>) request
				.getAttribute("subCategories");
	%>

	<a href="AddSubCategory.jsp">Add Sub Category</a>
	<br>
	<table border="1">
		<tr>
			<td>SubCategoryId</td>
			<td>SubCategoryName</td>
			<td>Action</td>
		</tr>
		<%
			for (SubCategoryBean cb : subCategories) {
		%>
		<tr>
			<td><%=cb.getSubCategoryId()%></td>
			<td><%=cb.getSubCategoryName()%></td>
			<td><a
				href="DeleteSubCategoryController?subCategoryId=<%=cb.getSubCategoryId()%>">
					Delete
			</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>