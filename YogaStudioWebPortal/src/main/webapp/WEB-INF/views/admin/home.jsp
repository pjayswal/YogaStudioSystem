
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
<jsp:param value="a" name="a"/>
</jsp:include>
<title>Welcome to Administration</title>
</head>
<body>
	<h1 class="text-center login-title">Welcome to Sakai System</h1>
	<h1 class="text-center login-title">----------------
		Administration ------------------</h1>
	<form style="text-align:center" >
	
		<!-- Standard button -->
	

		<a href="customer">
			<button type="button" class="btn btn-primary">Customer Administration</button>
		</a>
		
		<a href="faculty">
			<button type="button" class="btn btn-success">Faculty Administration</button>
		</a>
		
		<a href="course">
			<button type="button" class="btn btn-danger">Course Administration</button>
		</a>
		

	</form>

</body>
</html>