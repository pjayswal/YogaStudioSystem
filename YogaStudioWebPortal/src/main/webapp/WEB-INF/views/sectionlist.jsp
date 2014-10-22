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
<title>Welcome to Yoga Studio</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Sections in the Current Semester</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover">
					<thead>
						<tr>
							<th>Section ID</th>
							<th>Course</th>
							<th>Faculty</th>
							<th>Available Seats</th>
						</tr>
					</thead>

					<c:forEach var="sectionDataSet" items="${sections}">
						<tbody>
							<tr>
								<td>${sectionDataSet.id}</td>
								<td>${sectionDataSet.course.name}</td>
								<td>${sectionDataSet.faculty.name}</td>
								<td>${sectionDataSet.getAvailSeats()}</td>
								
							</tr>
						</tbody>
					</c:forEach>
				</table>

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