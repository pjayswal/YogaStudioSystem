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
	<div class="panel-heading">Products in the category:
		${category.name}</div>
	<div class="panel-body">
		<table data-toggle="table" class="table table-hover">
			<thead>
				<tr>
					<td>Product ID</td>
					<td>Name</td>
					<td>Description</td>
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

</body>
</html>