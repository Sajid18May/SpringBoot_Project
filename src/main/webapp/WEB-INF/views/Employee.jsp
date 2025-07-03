<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
</head>
<body>
<h2>Employee Registration Page ...</h2>
	<form action="saveEmp" method="post">
		<pre>
			First Name<input type="text" name="firstName">
			Last Name<input type="text" name="lastName">
			Email<input type="text" name="email">
			Mobile<input type="text" name="mobile">
			<button type="submit">Save</button>
		</pre>
	</form>
${mes}
</body>

</html>