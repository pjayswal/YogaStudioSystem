<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>

	<h1 align="center">
		<b>REGISTRATION FORM</b>
	</h1>
	<form:errors path="customer1.*"/>
	
	<form action="/YogaStudioWebPortal/submit"
		method="post">
		<p>
			Customer's Name : <input type="text" name="name" />
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

		<input type="submit" value="Register" />
	</form>
</body>
</html>
</body>
</html>