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
<title>Welcome to Administration</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	
	<div class="panel panel-primary">
		<div class="panel-heading">List of Semesters Available</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Semester ID</td>
						<td>Semester Name</td>
						<td>Semester Description</td>
						<td>Start Date</td>
						<td>End Date</td>
						<td>Details</td>

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
							<td><a href="./${semester.id}">View Details</a></td>
						</tr>
					</tbody>

				</c:forEach>
			</table>
			<a href="./add">
				<button type="button" class="btn btn-success">Add Semester</button>
			</a>
		</div>
	</div>

</body>