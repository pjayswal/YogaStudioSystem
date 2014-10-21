<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>YogaStudio Portal</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-dropdown.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<table style="width: 100%; text-align: center">
			<tr>
				<td><a class="navbar-brand" href="<c:url value="/home"/>">Home</a>
				</td>
				<td style="text-align: left"><label class="navbar-brand"><strong>Welcome
<%-- 							<sec:authentication property="Admin" /> --%>
					</strong></label></td>
				<td><a class="navbar-brand"
					href="<c:url value="/j_spring_security_logout"/>">Logout</a></td>
			</tr>
		</table>
	</div>
</div>