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
<title>List Courses</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">List of Courses</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover"
					data-toolbar="#transform-buttons">
					<thead>
						<tr>
							<th>Course ID</th>
							<th>Course Name</th>
							<th>Course Code</th>
							<th>Course Description</th>
							<th>Prerequisites</th>
							<th>Sections</th>
							<th>Edit</th>

						</tr>
					</thead>
					<c:forEach var="course" items="${courses}">
						<tbody>
							<tr>

								<td>${course.id}</td>
								<td>${course.name}</td>
								<td>${course.code}</td>
								<td>${course.description}</td>
								<td><select class="selectpicker">
										<c:forEach var="prereq" items="${course.prerequisites}">
											<option>${prereq.name}</option>
										</c:forEach>

								</select></td>
								<td><select class="selectpicker">
										<c:forEach var="section" items="${course.sections}">
											<option>${section.course.name},${section.faculty.name}</option>
										</c:forEach>

								</select></td>
								<td><a href="./${course.id}">edit</a></td>
							</tr>
						</tbody>

					</c:forEach>
				</table>
				<a href="./add">
					<button type="button" class="btn btn-success">Add Course</button>
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