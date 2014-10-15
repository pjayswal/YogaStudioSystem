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
	<div class="container">
	<form:form class="form-horizontal" role="form" commandName="semester"
			action="../semester/${semester.id}" method="post">

			<div class="form-group">
				<label class="col-sm-2 control-label">Name: </label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" path="name"
						autocomplete="on" value="${semester.name}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" path="description"
						value="${semester.description}" autocomplete="on" />
				</div>
				<div class="col-sm-3">
					<form:errors path="description" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">Start Date: </label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" path="dateFrom"
						autocomplete="on" value="${semester.dateFrom}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="dateFrom" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">End Date: </label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" path="dateTo"
						autocomplete="on" value="${semester.dateTo}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="dateTo" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Update</button>
				</div>
			</div>
			<%-- <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<a href="delete?id=${semester.id}">
					<button type="button" class="btn btn-primary">Delete</button>
				</a>
				</div>
			</div> --%>


		</form:form>

		

		
	</div>

	
	<div class="panel panel-primary">
		<div class="panel-heading">Sections in the Selected Course</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Section ID</td>
						<td>Course</td>
						<td>Faculty</td>
						<td>Number of student enrolled</td>
						<td>Details</td>
					</tr>
				</thead>

				<c:forEach var="section" items="${sections}">
					<tbody>
						<tr>
							<td>${section.id}</td>
							<td>${section.title}</td>
							<td>${section.faculty.name}</td>
							<td>${fn:length(section.students)}</td>
							<td><a href="../sections/${section.id}">View Details</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

		</div>
	</div>
	<a href="../sections/add?id=${course.id}">
			<button type="button" class="btn btn-success">Add Section</button>
	</a>
	
</body>
</html>