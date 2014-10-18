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
<title>Waiver List</title>
</head>
<br>
<br>
<br>
<br>
<div class="panel panel-primary">
	<div class="panel-heading">Prerequisites for the course:
		${section.course.name}</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<th>Section ID</th>
					<th>Course</th>
					<th>Faculty</th>
					<th>Available Seats</th>
					<th>Waiver</th>
				</tr>
			</thead>

			<c:forEach var="course" items="${courses}">
				<tbody>
					<tr>
						<%-- <td>${course.getSections.id}</td> --%>
						<td>${course.name}</td>
						<td>${course.faculty.name}</td>
						<td>${course.getSections.getAvailSeats()}</td>
						<td><a href="../waive/${sectionDataSet.section.id}">Waive</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</div>

</body>
</html>