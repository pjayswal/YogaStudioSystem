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
<title>Yoga Studio : Waiver List</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Prerequisites for the course:
				${section.course.name}</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover">
					<thead>
						<tr>
							<th>Course</th>
							<th>Course Code</th>
							<th>Description</th>
							<th>Apply for Waiver</th>
						</tr>
					</thead>

					<c:forEach var="course" items="${courses}">
						<tbody>
							<tr>
								<td>${course.name}</td>
								<td>${course.code}</td>
								<td>${course.description}</td>
								<%-- 						<form:form class="form-horizontal" role="form"
							commandName="waiver" action="./waive/" method="post">

							<div class="form-group">
								<label class="col-sm-2 control-label">Course: </label>
								<div class="col-sm-7">
									<form:input type="hidden" cssClass="form-control" path="course.id"
										value="${course.id}" readonly="true"  />
								</div>
								<div class="col-sm-3">
									<form:errors path="course.id" cssClass="error" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Description:</label>
								<div class="col-sm-7">
									<form:input type="description" cssClass="form-control"
										path="description" placeholder="description"
										autocomplete="off" />
								</div>
								<div class="col-sm-3">
									<form:errors path="description" cssClass="error" />
								</div>
							</div>


							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success">Waive</button>
								</div>
							</div>

						</form:form>
	 --%>
								<td><a href="../waiverform/${course.id}">Waive</a></td>
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