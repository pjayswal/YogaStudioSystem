<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div class="masthead">
	<h3 class="text-muted margin_top_10">
		<div class="row">
			<div class="col-lg-4">
				<div class="argonne_logo_img">
					<a href="<c:url value="/" />"><img
						src="<c:url value="/resources/images/yoga-studio-logo.jpg" />"
						class="img-responsive" alt="logo" /></a>
				</div>
				<div class="argonne_logo_txt"></div>
			</div>
			<div class="col-lg-5"></div>
			<div class="col-lg-3">
				<div class="need_help">
					Need Help?<br>Call extension 2-5373
				</div>
			</div>
		</div>
	</h3>

	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="<c:url value="/" />">HOME</a></li>
				<li class="dropdown"><a href="<c:url value="#" />">ABOUT US</a></li>
				<li class="dropdown"><a href="<c:url value="/section/" />">COURSE</a></li>
				<li class="dropdown"><a href="<c:url value="/shop/" />">SHOP</a></li>
				<li class="dropdown"><a href="<c:url value="#" />">FAQ</a></li>
				<li class="dropdown"><a href="<c:url value="#" />">CONTACT US</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="<c:url value="/login/" />">LOGIN
						<b class="glyphicon glyphicon-play"></b>
				</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
