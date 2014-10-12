<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
</head>
<body>

	<h1 align="center">
		<b>Add Course</b>
	</h1>
	<form:errors path="course1.*" />

	<form action="/YogaStudioWebPortal/addCourseSubmit" method="post">
		<p>
			Course Code : <input type="text" name="code" />
		</p>
		<p>
			Course Name: <input type="text" name="name" />
		</p>
		<p>
			Course Description : <textarea name="description" ROWS="3" COLS="25"></textarea>
		</p>
		<input type="submit" value="Add" />
	</form>
</body>
</html>
</body>
</html>


