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
	<h2>Details submitted by you::</h2>

	<table>
		<tr>
			<td>Customer Name :</td>
			<td>${customer1.name}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${customer1.email}</td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td>${customer1.phone}</td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>${customer1.dob}</td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td>${customer1.user.username}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${customer1.user.password}</td>
		</tr>
		
	</table>
		<footer>
			<p>&copy; Yoga Studio Portal 2014</p>
		</footer>
	</div>
</body>



<%-- 
<html>
<body>

	<h1>${welcomeMessage}</h1>
	<h2>Details submitted by you::</h2>

	<table>
		<tr>
			<td>Customer Name :</td>
			<td>${customer1.name}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${customer1.email}</td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td>${customer1.phone}</td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>${customer1.dob}</td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td>${customer1.user.username}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${customer1.user.password}</td>
		</tr>
		
	</table>
</body>
</html>
 --%>