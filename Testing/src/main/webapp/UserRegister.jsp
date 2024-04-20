<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
</head>
<body>
<form action="UserRegister" method="post">
		
<div align="center">
			<label> Firstname:<input type="text" id="fname" name="fname"></label>
		</div>
		<br>

		<div align="center">
			<label> Lastname:<input type="text" id="lname" name="lname"></label>
		</div>
		<br>
		
		<div align="center">
		  <input type="radio" id="male" name="uGender" value="male">
         <label for="male">Male</label><div>
         <input type="radio" id="female" name="uGender" value="female">
         <label for="male">Female</label><div>
         <br>
         
         <div align="center">
			<label> Age:<input type="text" id="age" name="age"></label>
		</div>
         <br>
		<div align="center">
			<label> Email:<input type="text" id="email" name="email"></label>
		</div>
		<br>
		<div align="center">
			<label> MobileNumber:<input type="text" id="mobile_No" name="mobileNo"></label>
		</div>
		<br>
		<div align="center">
			<label>DiscessType:<input type="text" id="discess_Type" name="discessType"></label>
		</div>
		<br>
		<div align="center">
		 <label for="Doctor">Doctor Name:</label>
  <select name="doctorName" id="doctorName">
  <option value=""></option>
    <option value="RamPrasath">RamPrasath</option>
    <option value="SanthiraSekar">SanthiraSekar</option>
    <option value="Ravinthiran">Ravinthiran</option>
    <option value="Geetha">Geetha</option>
  </select>
  <div>
  <br>
  <div align="center">
		 <label for="Doctor">Role:</label>
  <select name="roleOfPerson" id="roleOfPerson">
  <option value=""></option>
    <option value="Doctor">Doctor</option>
    <option value="Admin">Admin</option>
    <option value="superAdmin">superAdmin</option>
    <option value="patient">patient</option>
  </select>
  <div>
  <br>
		<div align="center">
			<label> Username:<input type="text" id="newname" name="newname"></label>
		</div>
		<br>
		<div align="center">
			<label> Password:<input type="text" id="newpass" name="newpass"></label>
		</div>
		<br>

		<div align="center">
			<label><input type="submit" value="Create"></label>
		</div>
		<br>
		<div align="center">
			<p>
				 Login <a href="LogInpage.jsp">Login Here</a>
		</div>
		</form>
</body>
</html>