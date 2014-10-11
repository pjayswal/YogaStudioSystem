<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Faculty</title>
</head>
<body>

	<h1 align="center">
		<b>Add Faculty</b>
	</h1>
	<form:errors path="faculty1.*" />

	<form action="/YogaStudioWebPortal/addFacultySubmit" method="post">
		<p>
			Faculty's Name : <input type="text" name="name" />
		</p>
		<p>
			Email : <input type="text" name="email" />
		</p>
		<p>
			Phone : <input type="text" name="phone" />
		</p>
		<p>
			Date of Birth : <input type="text" name="dob" />
		</p>
		<p>
			User Name : <input type="text" name="user.username" />
		</p>
		<p>
			Password : <input type="password" name="user.password" />
		</p>

		<p>
			Faculty's Description :
			<textarea name="bio" ROWS="3" COLS="25"></textarea>
		</p>

		<input type="submit" value="Add" />
	</form>
</body>
</html>
</body>
</html>


