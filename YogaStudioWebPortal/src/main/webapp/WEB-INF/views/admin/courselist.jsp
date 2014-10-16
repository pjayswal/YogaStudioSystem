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
<script type="text/javascript"
	src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
<script type="text/javascript"
	src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-dropdown.js"></script>
<title>Welcome to Administration</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">List of Courses Available</div>
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
							<td>
								<select class="selectpicker">
									<c:forEach var="prereq" items="${course.prerequisites}">
										<option>${prereq.name}</option>
									</c:forEach>

								</select>
							</td>
														<td>
								<select class="selectpicker">
									<c:forEach var="section" items="${course.sections}">
										<option>${section.course.name},${section.faculty.name}</option>
									</c:forEach>

								</select>
							</td>
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

</body>