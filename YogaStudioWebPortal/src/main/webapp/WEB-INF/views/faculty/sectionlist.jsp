<%@page import="org.ys.commons.Section"%>
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
<title>Welcome to Faculty</title>
</head>
<br>
<br>
<br>
<br>
<div class="panel panel-primary">
	<div class="panel-heading">Sections you are taking</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<th>Section ID</th>
					<th>Course</th>
					<th>Faculty</th>
					<th>Total Seats</th>
				</tr>
			</thead>

			<c:forEach var="section" items="${sections}">
				<tbody>
					<tr>
						<td>${section.id}</td>
						<td>${section.course.name}</td>
						<td>${section.faculty.name}</td>
						<td>${section.totalSeat}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</div>

</body>
</html>