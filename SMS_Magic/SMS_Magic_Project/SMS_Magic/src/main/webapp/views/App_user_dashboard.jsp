<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	long id_user=(long)session.getAttribute("id_user");
	out.println(id_user);
	
%>

<a href="/accessClientApp">View Apps from clients</a>

<a href="/view_accessed_apps">view accessed apps</a>



</body>
</html>