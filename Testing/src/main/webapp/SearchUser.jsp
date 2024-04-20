<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList,pack.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELLBEING</title>
</head>
<body>
	<div align="center">
		<div class="search-container">
			<form action="UserLogIn">
				<input type="text" placeholder="Search.." name="search">
				<button type="submit"></button>
			</form>
		</div>
	</div>
	<br>
	<br>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<script type="text/javascript">
function callServlet(userId) {

   // var servletname=document.getdata.fetchdata.value;
	alert(userId);
	var loginFlag = document.getElementById("loginFlag").value;
    alert("loginFlag"+loginFlag);
      /* if(userId== "")
        {
        alert("NO value..");
        return false;
        }
    else 
        {
        //alert("value"+servletname); */
       
        	document.LoadPatientDetails.action = "LoadPatientDetails?userId="+userId+"&loginFlag="+loginFlag;
            document.LoadPatientDetails.submit();
        
        
        
        //document.location.href="LoadPatientDetails;
        /* }  */
}

</script>
</head>
<body>
	<form name="LoadPatientDetails" method="post">
		<div align="center">
			<h2>PATIENT DETAILS</h2>
			<% String decision = (String)request.getAttribute("loadFlag"); %>
			<input type="hidden" id="loginFlag"  name="loginFlag" value="<%=decision%>">
			</div>
		<table>
			<tr>
				<th>USERID</th>
				<th>FIRST NAME</th>
				<th>LASTNAME</th>
				<th>GENDER</th>
				<th>AGE</th>
				<th>ROLE</th>
				<th>DOCTOR NAME</th>
				<th>ACTION</th>
				<th>RECORD</th>
				<%
				ArrayList<UserDTO> patientdetails = (ArrayList<UserDTO>) request.getAttribute("patientdetails");
				for (UserDTO userDTO : patientdetails) {
				%>
			
			<tr>
				<td><%=userDTO.getUserId()%></td>
				<td><%=userDTO.getFirstName()%></td>
				<td><%=userDTO.getLastName()%></td>
				<td><%=userDTO.getGender()%></td>
				<td><%=userDTO.getAge()%></td>
				<td><%=userDTO.getRoleOfPerson()%></td>
				<td><%=userDTO.getDoctorName()%></td>
				<td><input type="button" name="edit" value="EDIT"
					onclick="callServlet(<%=userDTO.getUserId()%>);"></td>
					<td><input type="button" name="view" value="VIEW"
					onclick="callServlet(<%=userDTO.getUserId()%>);"></td>	
			</tr>
			<%
			}
			%>

		</table>
	</form>
</body>
</html>