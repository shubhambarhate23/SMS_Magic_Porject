<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	long id1=(long)session.getAttribute("id");
	out.println(id1);
%>

<table border="1px solid black">
	<thead >
	
			<tr>
				<th>
					ID
				</th>
				<th>
					name
				</th>
				<th>email</th>
				<th>phone</th>
				
				<th>Status</th>
			</tr>
	
	</thead>
	
		<tbody>
		<c:forEach var="data" items="${clientlist}">
			<tr>
			<form action="/accessedAppByUser" method="post">
			 <input type="hidden" name="id" value="${data.id}">
				<td>
					${data.id}
				</td>
				<td >${data.name}</td>
				<td>${data.email}</td>
				<td>${data.phone}</td>
				<td><button type="submit" style="color:blue">Accessed</button></td>
			</form>
			</tr>
			</c:forEach>
		</tbody>
</table>

<a href="/App_user_dashboard">Back To dahshboard</a>
</body>
</html>