<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Well-Being</title>
<%@ include file="component/Allcss.jsp"%>
<style type="text/css">
.carousel-item:after {
	content: "";
	display: block;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.1);
}

.carousel-caption {
	top: 70%;
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="component/navber.jsp"%>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/pic.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/pic2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/pic3.webp" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>

		<div class="row">
			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-5">100% safty
						<p>
						<p>lorem ipsum dolor sit amet, constector appditions only this
							is hospital menagement</p>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card paint-card">
					<div class=" card-body">
						<p class="fs-5">clean Enviroment</p>
						<p>lorem ipsum dolor sit amet, constector appditions only this
							is hospital menagement</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="card paint-card">
					<div class=" card-body">
						<p class="fs-5">friendly Doctors</p>
						<p>lorem ipsum dolor sit amet, constector appditions only this
							is hospital menagement</p>
					</div>
				</div>
				</div>
			</div>
			<div class="col- md-4">
				<img alt="" src="">
			</div>
		</div>

    <hr>
    
    <div class="container p-2">
    <p class ="text-center fs-2"> Our Team</p>
    <div class= "row">
    <div class="col-md-3">
    <div class="card paint-card">
    <div class="card-body text-center">
    <img src="" width="250px" height="300px">
    <p class= "fw-bold fs-5">Samuani Simi</p>
    <p class="fs-7">(CEO & Chairman))</p>
    </div>
    </div>
    </div>
    
    
    <div class="col-md-3">
    <div class="card paint-card">
    <div class="card-body text-center">
    <img src="" width="250px" height="300px">
    <p class= "fw-bold fs-5">Siva Kumar</p>
    <p class="fs-7">(Chief Doctor)</p>
    </div>
    </div>
    </div>
    
    <div class="col-md-3">
    <div class="card paint-card">
    <div class="card-body text-center">
    <img src="" width="250px" height="300px">
    <p class= "fw-bold fs-5">Siva Kumar</p>
    <p class="fs-7">(Chief Doctor)</p>
    </div>
    </div>
    </div>
    
    <div class="col-md-3">
    <div class="card paint-card">
    <div class="card-body text-center">
    <img src="" width="250px" height="300px">
    <p class= "fw-bold fs-5">Siva Kumar</p>
    <p class="fs-7">(Chief Doctor)</p>
    </div>
    </div>
    </div>

</div>
    </div>

<%@include  file="component/footer.jsp" %>
	<!-- <!-- Bootstrap Bundle with Popper -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script> -->

</body>
</html>
