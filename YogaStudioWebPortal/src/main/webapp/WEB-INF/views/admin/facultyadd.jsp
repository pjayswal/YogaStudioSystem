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
<title>Welcome to Administration</title>
</head>

<body>
<br>
<br>
<br>


	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<label class="navbar-brand"><strong>Adding Faculty</strong></label>
		</div>
	</div>
	<div class="container">
		<form:form class="form-horizontal" role="form" commandName="faculty"
			action="./add" method="post">

			<div class="form-group">
				<label class="col-sm-2 control-label">Name:
					</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="name" placeholder="name"
						autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Email:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" 
						path="email" placeholder="email" />
				</div>
				<div class="col-sm-3">
					<form:errors path="email" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="phone" placeholder="phone" />
				</div>
				<div class="col-sm-3">
					<form:errors path="phone" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth:</label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" id="startdate"
						path="dob" placeholder="date of birth" />
				</div>
				<div class="col-sm-3">
					<form:errors path="dob" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Bio:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" 
						path="bio" placeholder="bio"  />
				</div>
				<div class="col-sm-3">
					<form:errors path="bio" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Username:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" 
						path="user.username" placeholder="username" />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.username" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-7">
					<form:input type="password" cssClass="form-control" 
						path="user.password" placeholder="password"  />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.password" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Save</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Sakai Portal 2014</p>
		</footer>
	</div>
</body>