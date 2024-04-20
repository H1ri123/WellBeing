<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELLBEING</title>
</head>
<body>

	<h1 align="center">WellBeing</h1>
	<form action="UserLogIn" method="post">
		<div align="center">
			<label> Username:<input type="text" id="Uname" name="Uname"></label>
		</div>
		<br>

		<div align="center">
			<label>Password :<input type="password" id="Upass"
				name="Upass"></label>
		</div>
		<br>

		<div align="center">
			<label><input type="submit" value="login"></label>
		</div>
		<br>

		<div align="center">
			<p>
				New user. <a href="UserRegister.jsp">Login Here</a>
		</div>
	</form>
</body>
</html>