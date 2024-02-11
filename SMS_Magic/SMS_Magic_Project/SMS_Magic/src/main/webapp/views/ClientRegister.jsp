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
<div class="a" >
<form action="/RegisterClient" method="POST">
        <label for="name">Name : </label>
        <input type="text" id="name" name="name" ><br><br>
        
        <label for="password">Password : </label>
        <input type="password" id="password" name="password" ><br><br>
        
        <label for="email">Email : </label>
        <input type="email" id="email" name="email" ><br><br>
        
        <label for="phone">Phone : </label>
        <input type="number" id="phone" name="phone" ><br><br>
        
        <input type="submit" value="Submit">
    </form>
    </div><br>
    
<a href="/login">Login Here...</a>

</body>
</html>