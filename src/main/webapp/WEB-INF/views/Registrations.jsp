<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Registrations Page</title>
</head>
<body>
	<h2>List Registrations Page</h2>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
		</tr>
<e:forEach var="emp" items="${employees}">
		<tr>
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
			<td>${emp.email}</td>
			<td>${emp.mobile}</td>
			<td><a href="deleteEmp?id=${emp.id}">delete</a></td>
			<td><a href="updateEmp?id=${emp.id}">Update</a></td>
		</tr>
</e:forEach>
	</table>
</body>
</html>