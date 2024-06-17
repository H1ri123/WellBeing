<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="navbar.jsp" %>
<p class="text-center fs-3">Doctor DashBoard</p>

<%
Doctor d=(Doctor)  session.getAttribute("docObj");
DoctorDao dao2=new DoctorDao(); 
%>
<div class="container  p-5">
<div class="row">
			<div class="col-md-4 offset-md-2">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-solid fa-user-md fa-3x"></i><br>
					<p class="fs-4 text-center">
						DOCTOR<br> <%=dao2.countDoctor()%>
					</p>
				</div>
			</div>
			</div>
			
			<div class="col-md-4 offset-md-2">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-solid fa-calender-check fa-3x"></i><br>
					<p class="fs-4 text-center">
						TOTAL APPOINTMENt<br><%=dao2.countAppointmentByDoctorId(d.getId()) %>
					</p>
				</div>
			</div>
			</div>
			</div>
			</div>
</body>
</html>