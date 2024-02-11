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
<form action="/LoginUser" method="POST">
        <label for="name">Username : </label>
        <input type="text" id="name" name="name" ><br><br>
        
        <label for="password">Password : </label>
        <input type="password" id="password" name="password" ><br><br>
        
        <input type="submit" value="Submit">
    </form>
    </div>
</body>
</html>