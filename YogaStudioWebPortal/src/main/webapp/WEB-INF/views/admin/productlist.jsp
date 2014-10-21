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
<title>Admin Home</title>
</head>

<body>

	<div class="container">

		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>


		<div class="panel panel-primary margin_top_20">
			<div class="panel-heading">Products in the category:
				${category.name}</div>
			<div class="panel-body">
				<table data-toggle="table" class="table table-hover">
					<thead>
						<tr>
							<td>Product ID</td>
							<td>Name</td>
							<td>Description</td>
							<td>IMage</td>
							<td>Price</td>
							<td>Edit</td>
						</tr>
					</thead>

					<c:forEach var="product" items="${products}">
						<tbody>
							<tr>
								<td>${product.id}</td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td><img src="../productpic/${product.id}">
								<td>${product.price}</td>
								<td><a href="../product/${product.id}">Edit</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>

			</div>
		</div>
		<a href="../product/add?category_id=${category.id}">
			<button type="button" class="btn btn-success">Add Product</button>
		</a>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>