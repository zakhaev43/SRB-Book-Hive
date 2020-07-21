<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/">
			<img src="../images/BookstoreAdminLogo.png" />
		</a>
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail}" /> | <a href="logout">Logout</a>
		<br/><br/>
	</div>
	<div id="headermenu">
		<div>
			<a href="list_users">
				<img src="https://img.icons8.com/color/96/000000/user-group-woman-woman.png"/><br/>Users
			</a>
		</div>
		<div>
			<a href="list_category">
				<img src="https://img.icons8.com/color/96/000000/category.png"/><br/>Categories
			</a>
		</div>
		<div>
			<a href="list_books">
				<img src="https://img.icons8.com/plasticine/100/000000/books.png"/> <br/>Books
			</a>
		</div>
		<div>
			<a href="list_customer">
			<img src="https://img.icons8.com/color/96/000000/category.png"/><br/>Customers
			</a>
		</div>
		<div>
			<a href="list_review">
				<img src="https://img.icons8.com/color/96/000000/category.png"/><br/>Reviews
			</a>
		</div>
		<div>
			<a href="list_order"><img src="https://img.icons8.com/color/96/000000/category.png"/><br/>
				Orders
			</a>
		</div>
	</div>
</div>