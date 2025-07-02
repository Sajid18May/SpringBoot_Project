<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h2>Registration Page</h2>
	<form action="saveReg" method="post">
		<pre>
			First Name<input type="text" name="firstName">
			Last Name<input type="text" name="lastName">
			Email<input type="text" name="email">
			Mobile<input type="text" name="mobile">
			City<input type="text" name="city">
			State<input type="text" name="state">
			Address Line<input type="text" name="addressLine">
			PinCode<input type="text" name="pinCode">
			<input type="submit" value="Registration">
		</pre>
	</form>
${msg}

</body>
</html>