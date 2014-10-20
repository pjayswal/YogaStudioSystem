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
			<form:form class="form-horizontal" role="form"
			action="../pay/" method="post" commandName="order">
        <h3> Checkout: Shipping an Payment information</h3>
			<div class="panel panel-default">
				<div class="panel-heading">Shipping Address Information</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-2 control-label">Street: </label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="shippingAddress.street"
								value="${order.shippingAddress.street}" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.street" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">City:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="shippingAddress.city"
								value="${order.shippingAddress.city}" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.city" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">State:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" 
								path="shippingAddress.state" 
								value="${order.shippingAddress.state}"/>
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.state" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Zip Code:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" 
								path="shippingAddress.zipCode" value="${order.shippingAddress.zipCode}" />
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.zipCode" cssClass="error" />
						</div>
					</div>

				</div>
			</div>			
			<div class="panel panel-default">
				<div class="panel-heading">Payment Information</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-2 control-label">Pay with:</label>
						<div class="col-sm-7">
						
						
						
						${payment}
						
						
						
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button type="submit" class="btn btn-success pull-right">Pay</button>
				</div>
			</div>			
		</form:form>
		<footer>
			<p>&copy; Yoga Studio Portal 2014</p>
		</footer>
	</div>
</body>





