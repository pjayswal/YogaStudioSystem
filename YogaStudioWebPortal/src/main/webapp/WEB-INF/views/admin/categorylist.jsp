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
		<div class="panel-heading">List of Product Categories Available</div>
		<div class="panel-body">
			<table data-toggle="table" class="table table-hover"
				data-toolbar="#transform-buttons">
				<thead>
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
						<th>Edit</th>
						<th>View Products</th>

					</tr>
				</thead>
				<c:forEach var="category" items="${categories}">
					<tbody>
						<tr>

							<td>${category.id}</td>
							<td>${category.name}</td>
							<td><a href="./${category.id}">edit</a></td>
							<td><a href="../product/?category_id=${category.id}">View Products</a></td>
						</tr>
					</tbody>

				</c:forEach>
			</table>
			<a href="./add">
				<button type="button" class="btn btn-success">Add Category</button>
			</a>
		</div>
	</div>

</body>