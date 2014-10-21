<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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


        <h3> Order confirmation</h3>
			<div class="panel panel-default">
				<div class="panel-heading">Order information</div>
				<div class="panel-body">

					<div class="form-group">
						<label class="col-sm-5 control-label"></label>
						<div class="col-sm-5 control-label">
						Your order # is ${order.id}. Thank you for shopping with us.
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<a href="../" class="btn btn-default">Continue Shopping</a>
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
	<script src="../resources/js/bootstrap.min.js"></script>
</body>
</html>