<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<jsp:directive.include file= "header.jsp"/>


	<div align="center">

		<h1>Enter your data for login</h1>

		<form action="">

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" id="email" size="20"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"
					size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Login</button>
				</td>
			</tr>
		</form>
	</div>


	<jsp:directive.include file= "footer.jsp"/>

</body>
</html>