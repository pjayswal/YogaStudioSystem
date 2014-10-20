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
	<div class="panel-heading">${faculty.name}: Your all advisees</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>User Name</th>
					<th>Date of Birth</th>
				</tr>
			</thead>

			<c:forEach var="customer" items="${customers}">
				<tbody>
					<tr>
						<td>${customer.getId()}</td>					
						<td>${customer.getName()}</td>
						<td>${customer.getEmail()}</td>
						<td>${customer.getPhone()}</td>
						<td>${customer.user.username}</td>
						<td>${customer.getDob()}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</div>

</body>
</html>