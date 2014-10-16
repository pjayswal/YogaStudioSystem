<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Name: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="name"
					autocomplete="on" value="${faculty.name}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="name" cssClass="error" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Email: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="email"
					autocomplete="on" value="${faculty.email}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="email" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Phone:</label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="phone"
					value="${faculty.phone}" autocomplete="on" />
			</div>
			<div class="col-sm-3">
				<form:errors path="phone" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Date of Birth: </label>
			<div class="col-sm-7">
				<form:input type="date" cssClass="form-control" path="dob"
					autocomplete="on" value="${fn:replace(faculty.dob,'-','/')}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="dob" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Bio: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="bio"
					autocomplete="on" value="${faculty.bio}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="bio" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Username: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="user.username"
					autocomplete="on" value="${faculty.user.username}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="user.username" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Password: </label>
			<div class="col-sm-7">
				<form:input type="password" cssClass="form-control" path="user.password"
					autocomplete="on" value="${faculty.user.password}" />
			</div>
			<div class="col-sm-3">
				<form:errors path="user.password" cssClass="error" />
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