<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> SRB BookStore Admin</title>
</head>
<body>
<jsp:directive.include file= "header.jsp"/>


	<div align="center">
		<h2 class="pageheading">Administrative Dashboard</h2>
	</div>
	
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Quick Actions:</h2>
		<b>
		<a href="new_book">New Book</a> &nbsp;
		<a href="user_form.jsp">New User</a> &nbsp;
		<a href="category_form.jsp">New Category</a> &nbsp;
		<a href="new_customer">New Customer</a>
		</b>
	</div>


<jsp:directive.include file= "footer.jsp"/>
</body>
</html>