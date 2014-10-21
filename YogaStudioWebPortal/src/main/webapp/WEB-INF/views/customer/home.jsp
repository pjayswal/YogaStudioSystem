<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Welcome to Yoga Studio</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>
		
		<!-- Carousel
	================================================== -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="../resources/images/stock-photo-banner.jpg"
						alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h2>Tip-tilting System</h2>
							<p>A design drawing of a two-stage tip-tilting system, having
								(1) a vertical-axis rotary top stage and (2) a horizontal-axis
								tip-tilting base stage, intended to position diamond crystals
								with nano-radian accuracy in an x-ray free-electron laser
								oscillator facility."</p>
							<p>
								<a class="btn btn-lg btn-primary btn-position" href="#"
									role="button">Learn More</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="../resources/images/stock-photo-banner2.jpg"
						alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h2>Sub-Molecular</h2>
							<p>Scanning tunneling microscope image, showing
								sub-molecular-resolution, of an iron phthalocyanine molecule
								(with its ball-and-stick structure inset). From "Engineering
								Nanostructures Atom by Atom for Optical Activity and Quantum
								Coherence (2009-204-N0.)"</p>
							<p>
								<a class="btn btn-lg btn-primary btn-position" href="#"
									role="button">Learn More</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="../resources/images/stock-photo-banner3.jpg"
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h2>X-ray Microscope</h2>
							<p>Transmission x-ray microscope reconstruction of a 2 × 3 ×
								4-micrometer volume within a dealloyed and coarsened nanoporous
								gold rod. From "Coherent Diffraction Imaging of Nonperiodic
								Materials (2008-171-R1)."</p>
							<p>
								<a class="btn btn-lg btn-primary btn-position" href="#"
									role="button">Learn More</a>
							</p>
						</div>
					</div>
				</div>
				<!--<div class="item">
		  <img src="../resources/images/stock-photo-banner4.jpg" alt="Fourth slide">
		  <div class="container">
			<div class="carousel-caption"> -->
				<!--<h2>Section Title4</h2>-->
				<!--  <p>While developing a matrix of anodic aluminum oxide for detection of molecules from hazardous materials, it was found that light reflected from the thinnest oxide layers (less than 500 nanometers) interfered with light reflected from the aluminum substrate to produce these interference colors.</p>
			  <p><a class="btn btn-lg btn-primary btn-position" href="#" role="button">Learn More</a></p>
			</div> 
		  </div>
		</div>-->
				<div class="item">
					<img src="../resources/images/stock-photo-banner5.jpg"
						alt="Fifth slide">
					<div class="container">
						<div class="carousel-caption">
							<h2>Mesostructure</h2>
							<p>Cross-polarization optical micrograph of a patterned
								silicon nitride substrate. A "mesostructure" was developed at an
								initial film thicknesses of 70 nanometers by means of hybrid
								annealing.</p>
							<p>
								<a class="btn btn-lg btn-primary btn-position" href="#"
									role="button">Learn More</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
				class="glyphicon glyphicon-chevron-left glyphicon-banner-size"></span></a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-right glyphicon-banner-size"></span></a>
		</div>
		<!-- /.carousel -->

		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<div class="border_small_banner">
					<img src="../resources/images/stock-photo-small-banner.jpg"
						class="img-responsive" alt="stock photo small banner" />
					<div class="image_caption">Lab Spotlight: Argonne – Inert
						Glove Box</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="row">
					<div class="col-lg-12">
						<h3>FY 2014 Proposal/Concept Paper Submission</h3>
						<p>
							New (Director&rsquo;s Competitive Grants [DCG]) and renewal (DCG
							and Strategic Initiative [SI]) proposals must be submitted at the
							YOGA STUDIO Proposal Submission website. New Strategic Initiative
							concept papers must be sent directly to the YOGA STUDIO Program
							Office at <a class="external_link" href="ldrd@anl.gov"
								target="_blank">ldrd@anl.gov</a>. Please refer to the guidance
							below when submitting a proposal to the YOGA STUDIO Program.
						</p>
						<div class="border_bottom_row"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 border_right_column">
						<h4 class="margin_top_zero">Calls for Proposals</h4>
						<p>Place a single sentence to help call out the Calls for
							Proposals to help introduce the links below.</p>
						<ul>
							<li><a href="#">FY 2014 Call for Director&rsquo;s
									Competitive Grants</a></li>
							<li><a href="#">FY 2014 Call for YOGA STUDIO Strategic
									Initiative</a></li>
							<li><a href="#">Concept Papers &amp; Proposals</a></li>
						</ul>
					</div>
					<div class="col-lg-6">
						<h4 class="margin_top_zero">Guidance and Documents</h4>
						<p>
						<ul>
							<li><a href="#">Project Description Outline</a><br>(for
								instructions to fill out this document, see guidance below)</li>
							<li><a href="#">FY 2014 Project Description Outline
									Guidance</a></li>
							<li><a href="#">FY 2014 YOGA STUDIO Program Guidance</a></li>
							<li><a href="#">FY 2014 YOGA STUDIO Activities Schedule</a></li>
							<li><a href="#">YOGA STUDIO Proposal Submission Tutorial
									(Videos)</a></li>
							<li><a href="#">Frequently Asked Questions</a></li>
						</ul>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="border_bottom_row"></div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4 border_right_column">
				<h4 class="margin_top_zero">Subject Matter Experts Needed</h4>
				<p>
					To enroll as a Subject Matter Expert for the FY 2014 YOGA STUDIO
					Cycle, please visit the <a href="#">YOGA STUDIO Subject Matter
						Expert Enrollment Page</a>. With sufficient participation, we expect
					no single SME will be asked to review more than four proposals and
					in most cases fewer.
				</p>
				<div class="row">
					<div class="col-lg-6"></div>
					<div class="col-lg-6">
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								More</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 border_right_column">
				<h4 class="margin_top_zero">Remaining FY 2013 YOGA STUDIO
					Funding Allocations Released</h4>
				<p>Each division office has been asked to prepare the necessary
					Work Project Authorization forms and has been asked to submit them
					to the Budget Office as soon as possible.</p>
				<div class="row">
					<div class="col-lg-6">&nbsp;</div>
					<div class="col-lg-6">
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								More</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<h4 class="margin_top_zero">Additional News</h4>
				<p>
				<ul>
					<li><a href="#">Important News Item 1 will go here</a></li>
					<li><a href="#">Important News Item 2 will go here</a></li>
					<li><a href="#">Important News Item 3 will go here</a></li>
					<li><a href="#">Important News Item 4 will go here</a></li>
					<li><a href="#">View All</a></li>
				</ul>
				</p>
			</div>
		</div>

		<jsp:include page="footer.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
</body>
</html>