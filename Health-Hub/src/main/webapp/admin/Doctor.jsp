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

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class=" fs-3 text-center">ADD DOCTOR</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action=../AddDoctor method="post">
							<div class="mb-3">
								<label class=" form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="mb-3">
								<label class=" form-label">DOB</label> <input type="date"
									required name="dob" class="form-control">
							</div>


							<div class="mb-3">
								<label class=" form-label">QUALIFICATION</label> <input
									type="text" required name="qualification" class="form-control">
							</div>

							<div class="mb-3">
								<label class=" form-label">SPECIALIST</label> <select
									name="spec" required class="form-control">
									<option>--Select--</option>

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
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class=" form-label">MOBLIE NO</label> <input type="text"
									required name="mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class=" form-label">PASSWORD</label> <input
									type="password" required name="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">SUBMIT</button>
						</form>
					</div>
				</div>
			</div>
			</div>
			</div>
</body>
</html>