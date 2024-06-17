<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="pack.Dto.*"%>
<%@page import="com.Dao.*"%>
<%@page import="java.util.*"%>
<%@page import="pack.jdbc.Connection.JdbcConnection.*"%>
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
	<c:if test="${empty docObj }">
		<c:redirect url="../Doctor_LogIn.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center">PATIENT DETAILS</p>
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success fs-3">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">FULL NAME</th>
									<th scope="col">GENDER</th>
									<th scope="col">AGE</th>
									<th scope="col">APPOINT DATE</th>
									<th scope="col">DISEASES</th>
									<th scope="col">DOCTOR NAME</th>
									<th scope="col">STATUS</th>

								</tr>
							</thead>
							<tbody>
								<%
								Doctor d = (Doctor) session.getAttribute("docObj");
								AppointmentDao dao = new AppointmentDao();
								List<Appointment> list = dao.getAllAppointmentByDoctorLogin(d.getId());
								for (Appointment ap : list) {
								%>

								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhNo()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=ap.getStatus()%></td>
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {
										%> <a href="Comment.jsp?id=<%=ap.getId()%>"
										class="btn btn-success btn-sm">Comment</a> <%
 } else {
 %> <a href="#" class="btn btn-success btn-sm disabled">Comment</a>

										<%
										}
										%>

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
	</div>

</body>
</html>