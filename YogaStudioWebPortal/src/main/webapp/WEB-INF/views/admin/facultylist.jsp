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
		<div class="panel-heading">List of Faculties Available</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>ID</td>
						<td>Name</td>					
						<td>Email</td>
						<td>Phone</td>
						<td>Date of Birth</td>
						<td>Bio</td>
						<td>Username</td>	
					</tr>
				</thead>
				<c:forEach var="faculty" items="${faculties}">
					<tbody>
						<tr>

							<td>${faculty.id}</td>
							<td>${faculty.name}</td>
							<td>${faculty.email}</td>
							<td>${faculty.phone}</td>
							<td>${faculty.dob}</td>
							<td>${faculty.bio}</td>
							<td>${faculty.user.username}</td>
							<td><a href="${faculty.id}">Edit</a></td>
						</tr>
					</tbody>

				</c:forEach>
			</table>
			<a href="add">
				<button type="button" class="btn btn-success">Add Faculty</button>
			</a>
		</div>
	</div>

</body>