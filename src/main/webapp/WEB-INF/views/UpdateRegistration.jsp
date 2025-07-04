<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<h2>Update Registration Page</h2>
	<form action="update?id=${emp.id}" method="post">
		<pre>
			First Name<input type="text" name="firstName" value="${emp.firstName}">
			Last Name<input type="text" name="lastName" value="${emp.lastName}">
			Email<input type="text" name="email" value="${emp.email}">
			Mobile<input type="text" name="mobile" value="${emp.mobile}">
			<input type="submit" value="Update">
		</pre>
	</form>
${msg}

</body>
</html>