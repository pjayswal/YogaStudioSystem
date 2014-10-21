<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Add Course</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>


		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Add Course</div>
			<div class="panel-body">
				<form:form class="form-horizontal" role="form" commandName="course"
					action="./add" method="post">

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
						<label class="col-sm-2 control-label">Course Code:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="code"
								placeholder="course code" />
						</div>
						<div class="col-sm-3">
							<form:errors path="code" cssClass="error" />
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
						<label class="col-sm-2 control-label">Prerequisites:</label>
						<div class="col-sm-7">
							<form:select path="prerequisites" multiple="true">
								<form:options items="${prerequisites}" itemLabel="name"
									itemValue="id" />
							</form:select>
						</div>
						<div class="col-sm-3">
							<form:errors path="prerequisites" cssClass="error" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<jsp:include page="footer.jsp">
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