<%@page import="pack.jdbc.Connection.JdbcConnection"%>
<%@page import="pack.Dto.Specalist"%>
<%@page import="pack.Dto.*"%>
<%@page import="com.Dao.*"%>
<%@page import="java.util.*"%>
<%@page import="pack.jdbc.Connection.JdbcConnection.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../component/Allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navber.jsp"%>
	<div class="container-fluid-p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<p class="fs-3 text-center">DOCTOR DETAILS</p>
					<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">FULL NAME</th>
								<th scope="col">DOB</th>
								<th scope="col">QUALIFICATION</th>
								<th scope="col">SPECIALIST</th>
								<th scope="col">EMAIL</th>
								<th scope="col">MOB NO</th>
								<th scope="col">ACTION</th>
							</tr>
						</thead>
						<tbody>
							<%
							DoctorDao doctorDao = new DoctorDao();
							List<Doctor> List = doctorDao.getAllDoctor();
							for (Doctor d : List) {
							%>
							<tr>
								<td><%=d.getFullName()%></td>
								<td><%=d.getDob()%></td>
								<td><%=d.getQualification()%></td>
								<td><%=d.getSpecialist()%></td>
								<td><%=d.getEmail()%></td>
								<td><%=d.getMobno()%></td>
								<td> <a href="edit_doctor.jsp?id=<%= d.getId() %>" class="btn btn-sm btn-primary">edit</a> 
									 <a href="../DeleteDoctor?id=<%=d.getId() %>" class="btn btn-sm btn-danger">delete</a>
							   </td>
							   </tr>
								<%
								}
								%>
							
						</tbody>
					</table>


				</div>
			</div>
		</div>
	</div>
</body>
</html>