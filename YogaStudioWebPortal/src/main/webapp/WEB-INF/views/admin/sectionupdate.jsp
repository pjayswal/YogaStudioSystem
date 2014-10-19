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
	<form:form class="form-horizontal" role="form" commandName="section"
		action="./add?semester_id=${section.semester.id}" method="post">

		<div class="form-group">
			<label class="col-sm-2 control-label">Semester: </label>
			<div class="col-sm-7">
				<form:input type="text" path="${semester.id}" value="${section.semester.id}" autocomplete="off"
					/>

			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="id"
					autocomplete="on" value="${section.id}" readonly="true" />
			</div>
			<div class="col-sm-3">
				<form:errors path="id" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Faculty:</label>
			<div class="col-sm-7">
				<form:select path="faculty">
					<form:options items="${faculties}" itemLabel="name" itemValue="id" />
				</form:select>
			</div>
			<div class="col-sm-3">
				<form:errors path="faculty" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Course:</label>
			<div class="col-sm-7">
				<form:select path="course">
					<form:options items="${courses}" itemLabel="name" itemValue="id" />
				</form:select>
			</div>
			<div class="col-sm-3">
				<form:errors path="course" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Total Seats: </label>
			<div class="col-sm-7">
				<form:input type="text" cssClass="form-control" path="totalSeat"
					placeholder="total seat" autocomplete="off" />
			</div>
			<div class="col-sm-3">
				<form:errors path="totalSeat" cssClass="error" />
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