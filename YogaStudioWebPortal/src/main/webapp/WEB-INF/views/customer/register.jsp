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
<title>Customer Registration</title>
</head>

<body>
	<br>
	<br>
	<br>


	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value=" /index.jsp"/>">Home</a>
			<label class="navbar-brand"><strong>Customer Registration Form</strong></label>
		</div>
	</div>
	<div class="container">
	<form:form class="form-horizontal" role="form" commandName="customer"
   action="./submit/" method="post">

			<div class="form-group">
				<label class="col-sm-2 control-label">Name: </label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" path="name"
						placeholder="name" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Email:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="email" placeholder="email" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="email" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="phone"
						path="phone" placeholder="phone" />
				</div>
				<div class="col-sm-3">
					<form:errors path="phone" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth:</label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" id="dob"
						path="dob" placeholder="date of birth" />
				</div>
				<div class="col-sm-3">
					<form:errors path="dob" cssClass="error" />
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">User Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="ususername"
						path="user.username" placeholder="username" />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.username" cssClass="error" />
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-7">
					<form:input type="password" cssClass="form-control" id="password"
						path="user.password" placeholder="password" />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.password" cssClass="error" />
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Yoga Studio Portal 2014</p>
		</footer>
	</div>
</body>







<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>

	<h1 align="center">
		<b>REGISTRATION FORM</b>
	</h1>
	<form:errors path="customer1.*"/>
	
	<form action="/YogaStudioWebPortal/submit"
		method="post">
		<p>
			Customer's Name : <input type="text" name="name" />
		</p>
		<p>
			Email : <input type="text" name="email" />
		</p>
		<p>
			Phone : <input type="text" name="phone" />
		</p>
		<p>
			Date of Birth : <input type="text" name="dob" />
		</p>
		<p>
			User Name : <input type="text" name="user.username" />
		</p>
		<p>
			Password : <input type="password" name="user.password" />
		</p>

		<input type="submit" value="Register" />
	</form>
</body>
</html>
</body>
</html>
 --%>

