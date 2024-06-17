<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="pack.Dto.*"%>
<%@page import="com.Dao.*"%>
<%@page import="java.util.*"%>
<%@page import="pack.jdbc.Connection.JdbcConnection.*"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/Allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: Linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/rese.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@ include file="component/navber.jsp"%>
<c:if test="${empty userObj }">
	<c:redirect url="User_Login.jsp"></c:redirect>
	</c:if>
	<div class="container-fuild backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">APPOINTMENT
							LIST</p>
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
							UserDetails  user= (UserDetails) session.getAttribute("userObj");
							AppointmentDao dao=new AppointmentDao();
							DoctorDao dao2=new DoctorDao();
		                    List<Appointment>  list= dao.getAllAppointmentByLoginUser(user.getId());
		                    for(Appointment ap:list){
		                    	Doctor d=dao2.getDoctorById(ap.getDoctorId());
		                    %>
		                    	<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge() %></td>
									<td><%=ap.getAppointDate() %></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=d.getFullName()%></td>
									
									
									<td>
									<%
									if("Pending".equals(ap.getStatus()))
									{%>
										<a href="#" class="btn btn-sm btn-warning">Pending</a>
									<%}else
									{%>
										<%=ap.getStatus()%>
									<%}
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

			<div class="col-md-3 p-3">
				<img alt="" src="img/femaleDoc.jpg">
			</div>
		</div>
	</div>

</body>
</html>