<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title }-OnlineBook Store</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<jsp:directive.include file="header.jsp" />


	<div align="center" style="width: 80%;">

		<table width="80%" style=""border:0">
			<tr>
				<td colspan="3" align="left"><h2>${book.title }</h2> by
					${book.author}</td>

			</tr>
			<tr>
				<td rowspan="2"><img class="book-small"
					src="data:image/jpg;base64,${book.base64Image}" width="240"
					height="300" /></td>
				<td valign="top" align="left">Rating *****</td>
				<td valign="top" rowspan="2" width="20%">$${book.price } <br />

					<button type="submit">Add to Cart</button>
				</td>


			</tr>
			<tr>
				<td valign="top">${book.description }
			</tr>

			<tr>&nbsp

			</tr>

			<tr>
				<td colspan="2" ><h2>Customer Reviews</h2></td>
				<td colspan="1" align="center">

					<button>Write a customer review</button>
				</td>

			</tr>
		</table width="80%">
		<div align="center"></div>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>