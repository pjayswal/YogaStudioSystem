<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<STYLE type="text/css">
.footer, .push {
	height: 220px; /* .push must be the same height as .footer */
}
* {
    margin: 0;
}
html, body {
    height: 100%;
}
.wrapper {
    min-height: 100%;
    height: auto !important;
    height: 100%;
    margin: 0 auto -155px; /* the bottom margin is the negative value of the footer's height */
}
</STYLE>
<div class="dasd">
	<div class="row footer">
		<div class="col-lg-12">

			<div class="row footer-bottom">
				<div class="col-lg-2 col-footer-width-1">
					<h5 class="border_right_column">
						<a href="<c:url value="/customer/home" />" style="color: #FFFFFF">&copy;
							2014 Yoga Studio</a>.
					</h5>
				</div>
				<div class="col-lg-2 col-footer-width-2">
					<h5 class="border_right_column">
						<a href="#">Office of Science</a>
					</h5>
				</div>
				<div class="col-lg-2 col-footer-width-3">
					<h5>
						<a href="#">Chicago Argonne LLC</a>
					</h5>
				</div>
				<div class="col-lg-2 col-footer-width-4">
					<h5 class="border_right_column">
						<a href="#">Privacy &amp; Security Notice</a>
					</h5>
				</div>
				<div class="col-lg-2 col-footer-width-5">
					<h5 class="border_right_column">
						<a href="#">Contact Us</a>
					</h5>
				</div>
				<div class="col-lg-2 col-footer-width-6">
					<h5>
						<a href="#">RSS Feeds</a>
					</h5>
				</div>
			</div>
		</div>
	</div>
</div>