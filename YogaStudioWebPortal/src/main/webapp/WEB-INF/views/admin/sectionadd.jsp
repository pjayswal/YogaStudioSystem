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
<title>Add Section</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Add Section in Semester:${semester.name}</div>
			<div class="panel-body">
				<form:form class="form-horizontal" role="form" commandName="section"
					action="./add?semester_id=${semester.id}" method="post">

					<div class="form-group">
						<label class="col-sm-2 control-label">Semester: </label>
						<div class="col-sm-7">
							<form:input type="text" path="semester.id" value="${semester.id}"
								autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="semester.id" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Faculty:</label>
						<div class="col-sm-7">
							<form:select path="faculty">
								<form:options items="${faculties}" itemLabel="name"
									itemValue="id" />
							</form:select>
						</div>
						<div class="col-sm-3">
							<form:errors path="faculty" cssClass="error" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Course:</label>
						<div class="col-sm-7">
							<form:select path="course">
								<form:options items="${courses}" itemLabel="name" itemValue="id" />
							</form:select>
						</div>
						<div class="col-sm-3">
							<form:errors path="course" cssClass="error" />
						</div>
					</div>

				<!DOCTYPE html >	<div class="form-group">
						<label class="col-sm-2 control-label">Total Seats: </label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="totalSeat"
								placeholder="total seat" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="totalSeat" cssClass="error" />
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