<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Welcome to Administration</title>
</head>
<br>
<br>
<br>
<br>
<div class="container">
	<form:form class="form-horizontal" role="form" commandName="faculty"
		action="./add" method="post">

		<div class="form-group">
			<label class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="id"
					autocomplete="on" value="${faculty.id}" readonly="true" />
			</div>
			<div class="col-sm-3">
				<form:errors path="name" cssClass="error" />
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">User Credential</div>
			<div class="panel-body">

				<div class="form-group">
					<label class="col-sm-2 control-label">User Name:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control" id="username"
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
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Basic Information</div>
			<div class="panel-body">

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
						<form:input type="text" cssClass="form-control" path="email"
							placeholder="email" autocomplete="off" />
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
					<label class="col-sm-2 control-label">Bio:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control" path="bio"
							placeholder="bio" />
					</div>
					<div class="col-sm-3">
						<form:errors path="bio" cssClass="error" />
					</div>
				</div>

			</div>
		</div>


		<div class="panel panel-default">
			<div class="panel-heading">Address Information</div>
			<div class="panel-body">

				<div class="form-group">
					<label class="col-sm-2 control-label">Street: </label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control"
							path="address.street" placeholder="Street" autocomplete="off" />
					</div>
					<div class="col-sm-3">
						<form:errors path="address.street" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">City:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control"
							path="address.city" placeholder="city" autocomplete="off" />
					</div>
					<div class="col-sm-3">
						<form:errors path="address.city" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">State:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control"
							path="address.state" placeholder="state" />
					</div>
					<div class="col-sm-3">
						<form:errors path="address.state" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Zip Code:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control"
							path="address.zipCode" placeholder="zip code" />
					</div>
					<div class="col-sm-3">
						<form:errors path="address.zipCode" cssClass="error" />
					</div>
				</div>

			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Update</button>
			</div>
		</div>

	</form:form>

</div>

</body>
</html>