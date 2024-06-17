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

	<div class="container p-4">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3">Change password</p>
					<p class="fs-4 text-center">User Login</p>
					<c:if test="${not empty succMsg}">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg}">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<div class="card -body">
						<form action="../EditDoctorProfile" method="post">
							<div class="mb-3">
								<label>Enter New PassWord</label><input type=text
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Old PassWord</label><input type=text
									name="oldPassword" class="form-control" required>
							</div>
							<input type="hidden" value="${docObj.id}" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-5 offset-md-2">
				<div class="card paint-card">
					<p class="text-center fs-3">EDIT PROFILE</p>
					<div class="card body">
					<c:if test="${not empty succMsgd}">
						<p class="text-center text-success fs-3">${succMsgd}</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsgd}">
						<p class="text-center text-danger fs-5">${errorMsgd}</p>
						<c:remove var="errorMsgd" scope="session" />
					</c:if>
						<form action=../EditProfile method="post">
							<div class="mb-3">
								<label class=" form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control" value="${docObj.fullName }">
							</div>

							<div class="mb-3">
								<label class=" form-label">DOB</label> <input type="date"
									required name="dob" class="form-control" value="${docObj.dob}" >
							</div>


							<div class="mb-3">
								<label class=" form-label">QUALIFICATION</label> <input
									type="text" required name="qualification" class="form-control" value="${docObj.qualification}" >
							</div>

							<div class="mb-3">
								<label class=" form-label">SPECIALIST</label> <select
									name="spec" required class="form-control">
									<option>${docObj.specialist}</option>

									<%
									SpecalistDao dao = new SpecalistDao();
									List<Specalist> list = dao.getAllSpecialist();
									for (Specalist s : list) {
									%>
									<option><%=s.getSpecalistName()%></option>
									<%
									}
									%>



								</select>
							</div>

							<div class="mb-3">
								<label class=" form-label">Email</label> <input type="text"
									readonly required name="email" class="form-control" value="${docObj.email}">
							</div>

							<div class="mb-3">
								<label class=" form-label">MOBLIE NO</label> <input type="text"
									required name="mobno" class="form-control" value="${docObj.mobno}">
							</div>

                                    <input type="hidden" name="id" value="${docObj.id}">

							<button type="submit" class="btn btn-primary">UPDATE</button>
						</form>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>