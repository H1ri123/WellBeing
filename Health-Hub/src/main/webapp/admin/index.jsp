<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%@ include file="navber.jsp"%>
	
	<c:if  test="${ empty adminObj}">
	
	<c:redirect url="../admin_Login.jsp"></c:redirect>
    </c:if>
	

	<div class="container p-5">
		<p class="text-center fs-3">Admin Dashboard</p>
		<c:if test="${not empty errorMsg}">
			<p class="text-center text-danger">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty succMsg}">
			<p class="fs-3 text-center text-success" role="alert">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<%DoctorDao dao2=new DoctorDao(); %>
		
		<div class="row">
			<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-solid fa-user-doctor"></i><br>
					<p class="fs-4 text-center">
						DOCTOR<br><%=dao2.countDoctor()%>
					</p>
				</div>
			</div>
			</div>


            <div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-solid fa-user"></i><br>
					<p class="fs-4 text-center">
				     	USER<br><%=dao2.countUser()%>
					</p>
				</div>
			</div>
			</div>			
			
			<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-solid fa-calendar-check"></i><br>
					<p class="fs-4 text-center">
						TOTAL APPOINTMENT<br><%=dao2.countAppointment()%>
					</p>
				</div>
			</div>
			
			</div>
			
			<div class="col-md-4 mt-2">
			<div class="card paint-card"  data-bs-toggle="modal" data-bs-target="#exampleModal">
				<div class="card-body text-center text-success">
					<i class="fa-regular fa-calendar-check"></i><br>
					<p class="fs-4 text-center">
						SPECIALIST<br><%=dao2.countSpecialist()%>
					</p>
				</div>
			</div>
			</div>
		</div>
	</div> 	
	

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body"> 
      <form action="../AddSpecialist" method="post">
      <div class ="form-group">
      <label>Enter Specilist Name</label>
      <input type ="text" name="specName" class="form-control">
      </div>
      <div class="text-center mt-3">
      <button type="submit" class="btn btn-primary"> Add</button>
      </div>
      </form>
      </div>
      <div class="modal-footer"> 
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>