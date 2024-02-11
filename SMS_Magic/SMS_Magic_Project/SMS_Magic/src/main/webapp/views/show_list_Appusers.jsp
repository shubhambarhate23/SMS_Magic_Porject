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
<form action="/accessedAppByUser" method="post">
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
				
				
			</tr>
	
	</thead>
	
		<tbody>
		<c:forEach var="data" items="${userList1}">
			<tr>
				<td>
					${data.id}
				</td>
				<td>${data.username}</td>
				<td>${data.email}</td>
				<td>${data.phone}</td>
			</tr>
			</c:forEach>
		</tbody>
</table>
</form>

</body>
</html>