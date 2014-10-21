<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Customer Registration</title>
</head>

<body>
	<br>
	<br>
	<br>



	<div class="container">
        <h3> Order confirmation</h3>
			<div class="panel panel-default">
				<div class="panel-heading">Thank you for your order!</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-5 control-label"></label>
						<div class="col-sm-5 control-label">
						Your order # is ${order.id} Thank you for shopping with us.
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<a href="../" class="btn btn-default">Continue Shopping</a>
				</div>
			</div>	
	</div>
</body>





