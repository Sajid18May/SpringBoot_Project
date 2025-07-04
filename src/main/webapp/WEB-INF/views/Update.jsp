<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<h2>Update Registration Page</h2>
	<form action="updateReg" method="post">
		<pre>
			First Name<input type="text" name="firstName">
			Last Name<input type="text" name="lastName">
			Email<input type="text" name="email">
			Mobile<input type="text" name="mobile">
			<input type="submit" value="Update">
		</pre>
	</form>
${msg}

</body>
</html>