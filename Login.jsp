<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>

		<div class="form-group">
			<label for="email">Email:</label> 
			<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
		</div> <br>
		
		<div class="form-group">
			<label for="pwd">Password:</label> 
			<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
		</div> <br>
		<div class="form-group form-check">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="remember">Remember me</label>
		</div> <br>
		<button type="submit" class="btn btn-primary">LOGIN</button>
	</form>
		<br>
		<p><a href="Dashboard.jsp">Dashboard</a></p>
</body>
</html>