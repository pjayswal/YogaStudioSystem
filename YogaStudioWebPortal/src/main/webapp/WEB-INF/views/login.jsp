<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="customer/header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Yoga Studio : Login</title>
</head>

<body>
	<%=request.getParameter("error")%>
	<div class="container">

		<jsp:include page="customer/menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="row margin_top_20 margin_bottom_20">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h2 class="text-center login-title">Sign in to Yoga Studio</h2>
				<div class="account-wall">
					<form class="form-signin" name='loginForm'
						action="<c:url value='/j_spring_security_check' />" method='POST'>

						<input type="text" name="username" class="form-control"
							placeholder="Username" required autofocus> <input
							type="password" name="password" class="form-control"
							placeholder="Password" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						<label class="checkbox pull-left margin_left_20"> <input type="checkbox"
							value="remember-me"> Remember me
						</label> <a href="#" class="pull-right need-help">Need help? </a><span
							class="clearfix"></span> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
				<a href="#" class="text-center new-account">Create an account </a>
			</div>
		</div>

		<jsp:include page="customer/footer.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>