<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Registration Success</title>
</head>

<body>
	<br>
	<br>
	<br>
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value=" /index.jsp"/>">Home</a>
			<label class="navbar-brand"><strong>Registration Success</strong></label>
		</div>
	</div>
	<div class="container">
	<h1>${welcomeMessage}</h1>
	<h5>An Email is sent to your email to your account verify y</h5>
		<footer>
			<p>&copy; Yoga Studio Portal 2014</p>
		</footer>
	</div>
</body>
