<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>

	<h2>Grab your freebies now!</h2>
	<form action="SignupServlet">
	
		<div class="form-group">
			<label for="email">FirstName:</label> 
			<input type="text" class="form-control" id="email" placeholder="Enter firstname" name="FirstName">
		</div> <br>
		
		<div class="form-group">
			<label for="email">Email:</label> 
			<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
		</div> <br>
		
		<div class="form-group">
			<label for="pwd">Password:</label> 
			<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
		</div> <br>
		<div class="form-group form-check">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="remember">Remember me</label>
		</div> <br>
		<button type="submit" class="btn btn-primary">SIGN UP</button>
	</form>
	
</body>
</html>