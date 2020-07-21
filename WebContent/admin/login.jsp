
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Login</title>
	<link rel="stylesheet" href="../css/style.css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
		<h2>Admin Login</h2>
		
		<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>
		
		<form id="loginForm" action="login" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" id="email" size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" size="20"></td>
				</tr>		
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>		
			</table>
		</form>
	</div>
<script type="text/javascript">

	$(document).ready(function() {
		$("#loginForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
		
				password: "required",
			},
			
			messages: {
				email: {
					required: "Please enter email",
					email: "Please enter an valid email address"
				},
				
				password: "Please enter password"
			}
		});

	});
</script>	
</body>
</html>