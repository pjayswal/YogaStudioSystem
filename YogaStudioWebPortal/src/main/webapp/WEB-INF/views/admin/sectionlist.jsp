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
<title>List Section</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>


		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Sections list in
				semester:${semester.name}</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover">
					<thead>
						<tr>
							<th>Section ID</th>
							<th>Course</th>
							<th>Faculty</th>
							<th>Number of student enrolled</th>
							<th>Available Seats</th>
							<th>Details</th>
						</tr>
					</thead>

					<c:forEach var="section" items="${sections}">
						<tbody>
							<tr>
								<td>${section.id}</td>
								<td>${section.course.name}</td>
								<td>${section.faculty.name}</td>
								<td>${fn:length(section.enrolledCustomers)}</td>
								<td>${section.getAvailSeats()}</td>
								<td><a href="../section/${section.id}">View Details</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>

				<a href="../section/add?semester_id=${semester.id}">
					<button type="button" class="btn btn-success">Add Section</button>
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