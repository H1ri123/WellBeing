<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList,pack.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
function backServlet(doctorName) {
	alert("SearchUSer.jsp"+doctorName);
	var loginFlag = document.getElementById("loginFlag").value;
    alert("loginFlag"+loginFlag);
    if(loginFlag =='doctor'){
    	alert("1");
    	var doctorName = document.getElementById("doctorName").value;
    	document.detailsForm.action = "LoadPatientDetailsDoctor?doctorName="+doctorName;
        document.detailsForm.submit();
    } else{
    	alert("2");
    	document.detailsForm.action ="LoadAllPaitentDetails";
        document.detailsForm.submit();
    }
	
	
}

//function saveServlet() {
//	alert("save called");
//	document.detailsForm.action ="SavePatientDetails";
//    document.detailsForm.submit();
//}
 function saveServlet() {
	alert("save called");
	document.detailsForm.action ="SavePatientDetails";
    document.detailsForm.submit();
 }

</script>
</head>
<body>
	<form name="detailsForm" method="post">
		<%
		UserDTO patientDetails = (UserDTO) request.getAttribute("patientDetails");
		
		
		//<input type="button" name="back" value="BACK" onclick="backServlet(<%SearchUser.jsp
		%>
		<% String decision = (String)request.getAttribute("loadFlag"); %>
		<input type="text" id="loginFlag" name="loginFlag"
			value="<%=decision%>">

		<div align="center">
			<label> USERID:<input type="text" id="userId" readonly
				name="userId" value=<%=patientDetails.getUserId()%>></label>
		</div>
		<br>

		<div align="center">
			<label> FISRTNAME:<input type="text" id="userName" readonly
				name="userName" value=<%=patientDetails.getFirstName()%>></label>
		</div>
		<br>

		<div align="center">
			<label> LASTNAME:<input type="text" id="lastName" readonly
				name="userName" value=<%=patientDetails.getLastName()%>></label>
		</div>
		<br>

		<div align="center">
			<label>GENDER :<input type="text" id="gender" readonly
				name="gender" value=<%=patientDetails.getGender()%>></label>
		</div>
		<br>

		<div align="center">
			<label> AGE:<input type="text" id="age" readonly name="age"
				value=<%=patientDetails.getAge()%>></label>
		</div>
		<br>

		<div align="center">
			<label>EMAIL:<input type="text" id="email" readonly
				name="email" value=<%=patientDetails.getUserEmail()%>></label>
		</div>
		<br>

		<div align="center">
			<label>MOBILE-NUMBER:<input type="text" id="mobileNo"
				readonly name="mobileNo" value=<%=patientDetails.getMobileNo()%>></label>
		</div>
		<br>

		<div align="center">
			<label>TYPE OF DISEADE:<input type="text" id="TypeOfDisease"
				readonly name="typeOfDisease"
				value=<%=patientDetails.getTypeOfDisease()%>></label>
		</div>
		<br>

		<div align="center">
			<label>DOCTOR NAME:<input type="text" id="doctorName"
				readonly name="doctorName" value=<%=patientDetails.getDoctorName()%>></label>
		</div>
		<br>

		<div align="center">
			<label>ROLE:<input type="text" id="role" readonly name="role"
				value=<%=patientDetails.getRoleOfPerson()%>></label>
		</div>
		<br>
		<hr>



		<div align="center">
			<label for="Appointment">APPOINTMENT:</label> <input type="date"
				id="appointment" name="appointment">
		</div>
		<br>
		<div align="center">
			<label> DOCTOR PRESCRIPTION:<input type="text"
				id="doctorPrescription" name="doctorPrescription"></label>
		</div>
		<br>

		<div align="center">
			<label>DOCTOR-FEES:<input type="text" id="doctorFees"
				name="doctorFees"></label>
		</div>
		<br>



		<div align="center">
			<label>BALANCE-FEES:<input type="text" id="balanceFees"
				name="balanceFees"></label>
		</div>
		<br>

		<div align="center">
			<label for="NextvisitDate">NEXT-VISITDATE:</label> <input type="date"
				id="nextVisitdate" name="nextVisitdate">
		</div>
		<br>


		<div align="center">
			<input type="button" name="save" value="SAVE" onclick="saveServlet()" />
			<input type="button" name="back" value="BACK"
				onclick="backServlet('<%=patientDetails.getDoctorName()%>')" />

		</div>
	</form>
</body>
</html>