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
<div class="container">
	<form:form class="form-horizontal" role="form" commandName="course"
		action="./add" method="post">

		<div class="form-group">
			<label class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="id"
					autocomplete="on" value="${course.id}" readonly="true" />
			</div>
			<div class="col-sm-3">
					<form:errors path="id" cssClass="error" />
				</div>
		</div>
		
	<div class="form-group">
				<label class="col-sm-2 control-label">Name:
					</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="name" placeholder="name"
						autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Course Code:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" 
						path="code" placeholder="course code" />
				</div>
				<div class="col-sm-3">
					<form:errors path="code" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-7">
					<form:input type="description" cssClass="form-control" 
						path="description" placeholder="description" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="description" cssClass="error" />
				</div>
			</div>

			
			<div class="form-group">
				<label class="col-sm-2 control-label">Prerequisites:</label>
				<div class="col-sm-7">
					<form:select path="prerequisites"  multiple="true">
					<form:options items="${prerequisites}"  itemLabel="name" itemValue="id"/>
					</form:select> 
				</div>
				<div class="col-sm-3">
					<form:errors path="prerequisites" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Update</button>
			</div>
		</div>


	</form:form>

</div>

</body>
</html>