<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SRB Book Hive- Online Book Store</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:directive.include file= "header.jsp"/>


<div align="center">


<h1>New Books</h1>
<div class="book-group">
		<c:forEach items="${listNewBooks}" var="book">
			<div class="book">
				<div>
					<a href="view_book?id=${book.bookId}">
						<img class="book-small" src="data:image/jpg;base64,${book.base64Image}" />
					</a>
				</div>
				<div>
					<a href="view_book?id=${book.bookId}">
						<b>${book.title}</b>
					</a>
				</div>
				<div>
					<jsp:directive.include file="book_rating.jsp" />				
				</div>
				<div><i>by ${book.author}</i></div>
				<div><b>$${book.price}</b></div>
			</div>
			
		</c:forEach>
	</div>
	
<h1>Best Selling Books:</h1>
<h1>Most-favored Book:</h1>
</div>

<jsp:directive.include file= "footer.jsp"/>
</body>
</html>