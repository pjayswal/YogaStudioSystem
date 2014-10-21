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
<title>Administrator Home</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Administration/Management System:
				${category.name}</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover">
						<tbody>
							<tr>
								<td>Semester/Section Management Options</td>
								<td>
									<a href="./semester/">
										<button type="button" class="btn btn-primary">View Semesters</button>
									</a>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr>
								<td>Course Management Options</td>
								<td>
									<a href="./course/">
										<button type="button" class="btn btn-primary">View Courses</button>
									</a>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr>
								<td>Faculty Management Options</td>
								<td>
									<a href="./faculty/">
										<button type="button" class="btn btn-primary">View Faculties</button>
									</a>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr>
								<td>Product Category/Product Management Options</td>
								<td>
									<a href="./category/">
										<button type="button" class="btn btn-primary">View Product Categories</button>
									</a>
								</td>
							</tr>
						</tbody>
					
				</table>

			</div>
		</div>
		<a href="../product/add?category_id=${category.id}">
			<button type="button" class="btn btn-success">Add Product</button>
		</a>

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