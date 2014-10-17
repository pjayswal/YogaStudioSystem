<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
 	
 	<%=request.getParameter("error") %>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Sign in to Yoga Studio Portal</h1>
				<div class="account-wall">
					<form class="form-signin" name='loginForm'
		  				action="<c:url value='/j_spring_security_check' />" method='POST'>
					
						<input type="text" name="username" class="form-control" placeholder="Username" required autofocus> 
						<input type="password" name="password" class="form-control" placeholder="Password" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						<label class="checkbox pull-left"> <input type="checkbox"
							value="remember-me"> Remember me
						</label> <a href="#" class="pull-right need-help">Need help? </a><span
							class="clearfix"></span>
							<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
					</form>
				</div>
				<a href="#" class="text-center new-account">Create an account </a>
			</div>
		</div>
	</div>
 	 
</body>
</html>