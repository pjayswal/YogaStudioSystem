<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Waiver</title>
</head>
<br>
<br>
<br>
<br>
<div class="container">
	<form:form class="form-horizontal" role="form" commandName="waiver"
		action="./add" method="post">

		<div class="form-group">
			<label class="col-sm-2 control-label">Course: </label>
			<div class="col-sm-7">
				<input type="text" value="${course.name}" readonly />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-7">
				<form:input type="hidden" cssClass="form-control" path="course.id"
					value="${course.id}" readonly="true" />
			</div>
			
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Description:</label>
			<div class="col-sm-7">
				<form:input type="description" cssClass="form-control"
					path="description" placeholder="description" autocomplete="off" />
			</div>
			<div class="col-sm-3">
				<form:errors path="description" cssClass="error" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Waive</button>
			</div>
		</div>


	</form:form>

</div>

</body>
</html>