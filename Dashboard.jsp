<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="homepageresources/assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="homepageresources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="homepageresources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="homepageresources/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="homepageresources/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="homepageresources/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="homepageresources/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="homepageresources/assets/css/style.css" rel="stylesheet">
</head>
</head>
<body>

	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
	<header id="header" class="fixed-top header-inner-pages">
		<div
			class="container d-flex align-items-center justify-content-between">

			<h1 class="logo">
				<a href="index.html">Welcome to Dashboard</a>

			</h1>
		</div>
	</header>


	<section id="hero">
		<div id="heroCarousel" data-bs-interval="5000"
			class="carousel slide carousel-fade" data-bs-ride="carousel">
			<ol class="carousel-indicators" id="hero-carousel-indicators"></ol>
			<div class="carousel-inner" role="listbox">

				<!-- Slide 1 -->
				<div class="carousel-item active"
					style="background-image: url(assets/img/slide/slide-1.jpg)">
					<div class="carousel-container">
						<div class="container">
							<h2 class="animated fadeInDown">
								<span>Expense Counter Application</span>
							</h2>
							<p>
								A monthly expense tracker app automates the process of recording
								transactions, totaling expenses by category and tracking
								progress toward goals. <br>Tech-savvy smartphone apps have
								made monitoring spending habits, tracking expenses and managing
								money a breeze.
							</p>
							<a href="#about"
								class="btn-get-started animated fadeInUp scrollto">Read More</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<br>
	<br> &nbsp; 1.
	
	<a href="AddCategory.jsp">Add Category</a>
	<br> &nbsp; 2.
	<a href="AddSubCategory.jsp">Add SubCategory</a>
	<br> &nbsp; 3.
	<a href="ListUserController">All Users</a>
	<br> &nbsp; 4.
	<a href="ListCategoriesController">List All Categories</a>
	<br>


	<br>
	
	<!-- ======= Footer ======= -->
	<footer id="footer">

		<div class="footer-newsletter">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<h4>Our Newsletter</h4>
						<p>We don't provide....!</p>
					</div>
					<div class="col-lg-6">
						<form action="" method="post">
							<input type="email" name="email"><input type="submit"
								value="Subscribe">
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="footer-top">
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-xl-10">
						<div class="row">
							<div class="col-lg-3 col-md-6 footer-contact">
								<h4>Contact Us</h4>
								<p>
									Royal Technosoft<br> Vasant Vihar, <br> Navrangpura,
									Ahmedabad, Gujarat 380052<br> <br> <strong>Phone:</strong>
									+91 9904543933<strong><br>Email:</strong> janvi@gmail.com<br>
								</p>
							</div>

							<div class="col-lg-3 col-md-6 footer-info">
								<h3>About Expense Counter</h3>
								<p>
									A monthly expense tracker app automates the process of
									recording transactions, totaling expenses by category and
									tracking progress toward goals. <br>Tech-savvy smartphone
									apps have made monitoring spending habits, tracking expenses
									and managing money a breeze.
								</p>
								<div class="social-links mt-3">
									<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
									<a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
									<a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
									<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
									<a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong><span>Expense Counter</span></strong>. All
				Rights Reserved
			</div>
			<div class="credits"></div>
		</div>
	</footer>
	<!-- End Footer -->
</body>
</html>