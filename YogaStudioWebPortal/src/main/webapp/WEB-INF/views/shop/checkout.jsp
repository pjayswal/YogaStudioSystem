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
		<form:form class="form-horizontal" role="form" commandName="customer"
			action="./submit/" method="post">
        <h3> Checkout: Review order</h3>
			<div class="panel panel-default">
				<div class="panel-heading">Shipping Address Information</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-2 control-label">Street: </label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="address.street"
								placeholder="Street" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="address.street" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">City:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" path="address.city"
								placeholder="city" autocomplete="off" />
						</div>
						<div class="col-sm-3">
							<form:errors path="address.city" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">State:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" 
								path="address.state" placeholder="state" />
						</div>
						<div class="col-sm-3">
							<form:errors path="address.state" cssClass="error" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Zip Code:</label>
						<div class="col-sm-7">
							<form:input type="text" cssClass="form-control" 
								path="address.zipCode" placeholder="zip code" />
						</div>
						<div class="col-sm-3">
							<form:errors path="address.zipCode" cssClass="error" />
						</div>
					</div>

				</div>
			</div>			
			<div class="panel panel-default">
				<div class="panel-heading">Pay with</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-2 control-label">Select payment:</label>
						<div class="col-sm-7">
      <div class="dropdown theme-dropdown clearfix">
        <a id="dropdownMenu1" href="#" role="button" class="sr-only dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
          <li class="active" role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
        </ul>
      </div>
						</div>
						<div class="col-sm-3">
							<form:errors path="user.username" cssClass="error" />
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Yoga Studio Portal 2014</p>
		</footer>
	</div>
</body>





