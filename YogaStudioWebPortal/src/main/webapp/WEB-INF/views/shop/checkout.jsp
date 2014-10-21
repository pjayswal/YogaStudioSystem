<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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

	<br/>
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
								value="${customer.address.street}" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.street" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">City:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="shippingAddress.city"
								value="${customer.address.city}" autocomplete="off" />
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
								value="${customer.address.state}"/>
						</div>
						<div class="col-sm-3">
							<form:errors path="shippingAddress.state" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Zip Code:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" 
								path="shippingAddress.zipCode" value="${customer.address.zipCode}" />
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
						
						
						
						
						
						
						
						
						
						<ul class="list-unstyled">
							<li>
								<input type="radio" name="pmtmthd" id="VISAMASTER_PAYPAL" checked="checked"
								value="VISAMASTER_PAYPAL"><label for="VISAMASTER_PAYPAL"><img src="https://secureir.ebaystatic.com/pictures/aw/pics/checkout/payments/paypal/ppguest_1.gif" border="0"/>
								</label><div class="bmldiv">&nbsp;&nbsp;Processed by PayPal</div>
							</li>
							<li>
								<input type="radio" name="pmtmthd"	id="PAYPAL"									
								value="PAYPAL"><label for="PAYPAL"><img src="https://secureir.ebaystatic.com/pictures/aw/pics/checkout/payments/paypal/pymt_paypal.png" border="0"/></label>
							</li>
							<li>
								<input type="radio" name="pmtmthd"	id="CREDITCARD"
								value="CREDITCARD"><label for="CREDITCARD" class="fcccc">Credit card</label>
							</li>
						</ul>	
						
						
						
						
						
						
						
						
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="submit" class="btn btn-primary pull-right">Pay</button>
				</div>
			</div>			
		</form:form>
       
       
       


		<jsp:include page="footer.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
</body>
</html>
