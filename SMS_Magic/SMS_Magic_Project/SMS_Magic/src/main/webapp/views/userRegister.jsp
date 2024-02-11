<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.a{
	 border: 1px solid black;
	 margin-top: 10px;
	 height : 200px;
	 width:300px;
	 margin-left:400px;
}
form
{
	margin:10px;
}

a{
	margin-left:400px;
}

</style>
</head>
<body>
	${message}
	<div class="a">
	<form action="/User_register" method="post">

		<label for="username">Username:</label> <input type="text"
			id="username" name="username"><br> <label for="email">Email:</label>
		<input type="email" id="email" name="email"><br> <label
			for="phone">Phone:</label> <input type="number" id="phone"
			name="phone"><br> <label for="Role">User_Role :
		</label> <select id="role" name="role">
			<option value="App_USER">App_user</option>
			<option value="ROLE_ADMIN">Admin</option>
			<option value="ROLE_Employee">Employee</option>
		</select><br>
		<br> <label for="password">Password:</label> <input
			type="password" id="password" name="password"><br> <input
			type="submit">
	</form>
</div>
	<a href="/ulogin">Login</a>
</body>
</html>