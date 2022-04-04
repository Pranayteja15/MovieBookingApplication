<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<style>
Body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: white;
}
button {
	background-color: #4CAF50;
	width: 100%;
	color: orange;
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}
form {
	border: 3px solid #f1f1f1;
}
input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid green;
	box-sizing: border-box;
}
button:hover {
	opacity: 0.7;
}
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}
.container {
	padding: 25px;
	background-color: white;
}
</style>
</head>
<body>
	<center>
		<h1>Login Form</h1>
	</center>
	<h3>Enter Credentials for Login in MoviesAdda</h3>
	<form action="checkLogin" method="post">
		<div class="container">
			<label>Username or Email: </label> <input type="text" placeholder="Enter username"
				name="username" required> <label>Password : </label> <input
				type="password" placeholder="Enter Password" name="password"
				required>
			<button type="submit">Login</button>
		</div>
	</form>
		
	<form action="signup">
		<div class="container">
			<label>For New Users</label>
			<button type="submit">Sign up</button>
		</div>
	</form>

</body>
</html>
>