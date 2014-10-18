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
<title>Welcome to Administration</title>
</head>
<br>
<br>
<br>
<br>
<div class="panel panel-primary">
	<div class="panel-heading">Sections in the Current Semester</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<th>Section ID</th>
					<th>Course</th>
					<th>Faculty</th>
					<th>Available Seats</th>
					<th>Enroll</th>
				</tr>
			</thead>

			<c:forEach var="sectionDataSet" items="${sectionDataSets}">
				<tbody>
					<tr>
						<td>${sectionDataSet.section.id}</td>
						<td>${sectionDataSet.section.course.name}</td>
						<td>${sectionDataSet.section.faculty.name}</td>
						<td>${sectionDataSet.section.getAvailSeats()}</td>
						<c:if test="${sectionDataSet.option=='ENROLLED'}">
							<td>Already Enrolled</td>
						</c:if>
						<c:if test="${sectionDataSet.option=='ENROLL'}">
							<td><a href="../enroll/${sectionDataSet.section.id}">Enroll</a></td>
						</c:if>
						<c:if test="${sectionDataSet.option=='WAIVE'}">
							<td><a href="../waiver/${sectionDataSet.section.id}">Waive</a></td>
						</c:if>


					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</div>

</body>
</html>