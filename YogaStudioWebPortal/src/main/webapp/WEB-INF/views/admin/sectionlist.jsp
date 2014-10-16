<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
<jsp:param value="a" name="a"/>
</jsp:include>
<title>Welcome to Administration</title>
</head>
<br>
<br>
<br>
<br>
		<div class="panel panel-primary">
		<div class="panel-heading">Sections in the semester: ${semester.name}</div>
		<div class="panel-body">
			<table data-toggle="table" class="table table-hover">
				<thead>
					<tr>
						<th>Section ID</th>
						<th>Course</th>
						<th>Faculty</th>
						<th>Number of student enrolled</th>
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
							<td><a href="../section/${section.id}">View Details</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

		</div>
	</div>
	<a href="../section/add?semester_id=${semester.id}">
			<button type="button" class="btn btn-success">Add Section</button>
	</a>
	
</body>
</html>