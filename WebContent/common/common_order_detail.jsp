	<div align="center">
		<h2>Order Overview:</h2>
		<table>
			<tr>
				<td><b>Ordered By: </b></td>
				<td>${order.customer.fullName}</td>
			</tr>
		      <tr>
				<td><b>Order Status: </b></td>
				<td>${order.status}</td>
			</tr>
			<tr>
				<td><b>Order Date: </b></td>
				<td>${order.orderDate}</td>
			</tr>
			<tr>
				<td><b>Payment Method: </b></td>
				<td>${order.paymentMethod}</td>
			</tr>						
			<tr>
				<td><b>Book Copies: </b></td>
				<td>${order.bookCopies}</td>
			</tr>
			<tr>
				<td><b>Total Amount: </b></td>
				<td><fmt:formatNumber value="${order.total}" type="currency" /></td>
			</tr>
		</table>
		<h2>Recipient Information</h2>
		<table>			
			<tr>
				<td><b>Full Name: </b></td>
				<td>${order.recipientName}</td>
			</tr>
						
			<tr>
				<td><b>Phone: </b></td>
				<td>${order.recipientPhone}</td>
			</tr>
			
			<tr>
				<td><b>Shipping Address   </b></td>
				<td>${order.shippingAddress}</td>
			</tr>					
			
																	
		</table>
	</div>
	<div align="center">
		<h2>Ordered Books</h2>
		<table border="1">
			<tr>
				<th>Index</th>
				<th>Image</th>
				<th>Book Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</thd>
			</tr>
			<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>
					<img style="vertical-align: middle;" src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="48" height="64" />

				</td> 
				<td>${orderDetail.book.title}</td>
				<td>${orderDetail.book.author}</td>
				<td><fmt:formatNumber value="${orderDetail.book.price}" type="currency" /></td>
				<td>${orderDetail.quantity}</td>
				<td><fmt:formatNumber value="${orderDetail.subtotal}" type="currency" /></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right">
					<%-- <p>Subtotal: <fmt:formatNumber value="${order.orderDetails.subtotal}" type="currency" /></p> --%>
					<%-- <p>Tax: <fmt:formatNumber value="${order.tax}" type="currency" /></p> --%>
					<%-- <p>Shipping Fee: <fmt:formatNumber value="${order.shippingFee}" type="currency" /></p> --%>
					<p>TOTAL: <fmt:formatNumber value="${order.total}" type="currency" /></p>
				</td>
			</tr>
		</table>
	</div>