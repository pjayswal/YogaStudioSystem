<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Section</title>
</head>
<body>

	<h1 align="center">
		<b>Add Section</b>
	</h1>
	<form:errors path="section1.*" />

	<form action="/YogaStudioWebPortal/addSectionSubmit" method="post">
		<p>
			Course: <input type="text" name="code" />
		</p>
		<p>
			Semester: <input type="text" name="name" />
		</p>
		<p>
			Total Seat: <input type="text" name="name" />
		</p>
		<p>
			Faculty: <input type="text" name="name" />
		</p>
		<input type="submit" value="Add" />
	</form>
</body>
</html>
</body>
</html>


