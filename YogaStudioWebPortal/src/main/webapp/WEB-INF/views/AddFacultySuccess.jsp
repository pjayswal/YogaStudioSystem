<html>
<body>

	<h1>${welcomeMessage}</h1>
	<h2>Details submitted by you::</h2>

	<table>
		<tr>
			<td>Faculty's Name :</td>
			<td>${faculty1.name}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${faculty1.email}</td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td>${faculty1.phone}</td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>${faculty1.dob}</td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td>${faculty1.user.username}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${faculty1.user.password}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td>${faculty1.bio}</td>
		</tr>
	</table>
</body>
</html>
