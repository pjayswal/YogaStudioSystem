<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>List Semester</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">List of Semesters</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover"
					data-toolbar="#transform-buttons">
					<thead>
						<tr>
							<th>Semester ID</th>
							<th>Semester Name</th>
							<th>Semester Description</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Edit</th>
							<th>View Sections</th>

						</tr>
					</thead>
					<c:forEach var="semester" items="${semesters}">
						<tbody>
							<tr>

								<td>${semester.id}</td>
								<td>${semester.name}</td>
								<td>${semester.description}</td>
								<td>${semester.dateFrom}</td>
								<td>${semester.dateTo}</td>
								<td><a href="./${semester.id}">edit</a></td>
								<td><a href="../section/?semester_id=${semester.id}">View
										Sections</a></td>
							</tr>
						</tbody>

					</c:forEach>
				</table>
				<a href="./add">
					<button type="button" class="btn btn-success">Add Semester</button>
				</a>
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