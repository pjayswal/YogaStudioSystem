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
	<div class="panel-heading">All Waiver List</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<th>Course</th>
					<th>Customer</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="waiver" items="${waivers}">
				<tbody>
					<tr>
						<td>${waiver.course.name}</td>
						<td>${waiver.customer.name}</td>
						<td><a href="../accept/${waiver.id}">Accept</a> / <a href="../reject/${waiver.id}">Reject</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</div>

</body>
</html>