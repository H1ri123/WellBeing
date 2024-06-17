<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-stethoscope"></i>WELL-BEING</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"><i
						class="fas fa-sign-in-alt"></i>HOME</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="patient.jsp"><i
						class="fas fa-sign-in-alt"></i>PATIENT</a></li>
			</ul>

			<form class="d-flex">
				<div class="dropdown">
					<button class="btn btn-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">${docObj.fullName}</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="edit_Profile.jsp">EDIT
								PROFILE</a></li>
						<li><a class="dropdown-item" href="../DoctorLogout">LOG OUT</a></li>
					</ul>
				</div>
			</form>

		</div>
	</div>
</nav>
