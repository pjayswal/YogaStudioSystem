<html>
<body>

	<h1>${welcomeMessage}</h1>
	<h2>Details submitted by you::</h2>

	<table>
		<tr>
			<td>Customer Name :</td>
			<td>${customer1.name}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${customer1.email}</td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td>${customer1.phone}</td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>${customer1.dob}</td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td>${customer1.user.username}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${customer1.user.password}</td>
		</tr>
		
	</table>
</body>
</html>
