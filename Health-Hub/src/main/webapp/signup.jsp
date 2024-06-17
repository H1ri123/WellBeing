<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/Allcss.jsp"%>
<style type="text/css">
.paint2-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="component/navber.jsp"%>

<div class="container p-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<c:if test="${not empty sucMge}">
				<p class="text-center text-success fs-3">${sucMge}</p>
				<c:remove var="sucMge" scope="session"/>
			</c:if>
			
			<c:if test="${not empty errorMsg}">
				<p class="text-center text-danger fs-3">${errorMsg}</p>
				<c:remove var="errorMsg" scope="session"/>
			</c:if>
			<div class="paint2-card">
				<div class="card-body">
					<p class="fs-4 text-center">User Register</p>
					<form action="UserRegister" method="post">
						<div class="mb-3">
							<label class="form-label">Full Name</label>
							<input required name="fullname" type="text" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Email Address</label>
							<input required name="email" type="email" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label>
							<input required name="password" type="password" class="form-control">
						</div>
						<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
					</form> 
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
