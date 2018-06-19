<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Insert title here</title>
	</head>
	<body>
	<h1>Welcome to <c:out value="${dojo.name}"></c:out></h1>
	
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			
			</tr>
		
		</thead>
		<tbody>
			<c:forEach items="${dojo.ninjas}" var="b">
			<tr>
				<td><c:out value="${b.firstName}"></c:out></td>
				<td><c:out value="${b.lastName}"></c:out></td>
				<td><c:out value="${b.age}"></c:out></td>
			</tr>
		</c:forEach>
		</tbody>
	
	
	</table>
</body>
</html>