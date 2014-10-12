<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Semester</title>
</head>
<body>

	<h1 align="center">
		<b>Add Semester</b>
	</h1>
	<form:errors path="semester1.*" />

	<form action="/YogaStudioWebPortal/addSemesterSubmit" method="post">
		<p>
			Semester Name : <input type="text" name="name" />
		</p>
		<p>
			Description :
			<textarea name="description" ROWS="3" COLS="25"></textarea>
		</p>
		<p>
			Start Date: <input type="text" name="dateFrom" />
		</p>
		<p>
			End Date: <input type="text" name="dateTo" />
		</p>
		<input type="submit" value="Add" />
	</form>
</body>
</html>
</body>
</html>


