package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;

public class OrderDAOTest {
	
	private static OrderDAO orderDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		orderDAO= new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	public void testCreateBookOrder() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(2);
		
		order.setCustomer(customer);
		order.setPaymentMethod("paypal");
		order.setRecipientName("Saifur Rahman Bhuiyan");
		
		order.setRecipientPhone("123456");
		order.setShippingAddress("Dresden");
	
		
			
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		OrderDetail orderDetail= new OrderDetail();
		OrderDetailId orderDetailId = new OrderDetailId();
		
		Book book = new Book(25);
		orderDetail.setBook(book);
		orderDetail.setQuantity(2);
		orderDetail.setSubtotal(68.0f);
		orderDetail.setBookOrder(order);
		
		orderDetail.setId(orderDetailId);
		orderDetails.add(orderDetail);
		
		order.setOrderDetails(orderDetails);
		
	
		
		BookOrder savedOrder=orderDAO.create(order);
		assertTrue(order.getOrderId() > 0 );
	}

	@Test
	public void testUpdateBookOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Integer orderId = 25;
		BookOrder order = orderDAO.get(orderId);
		
		
		
		assertEquals(1, order.getOrderDetails().size());
	}

	@Test
	public void testDeleteOrder() {
		int orderId = 9;
		orderDAO.delete(orderId);
		
		BookOrder order = orderDAO.get(orderId);
		
		assertNull(order);
	}

	@Test
	public void testListAll() {
List<BookOrder> listOrders = orderDAO.listAll();
	
		
		assertTrue(listOrders.size() == 0);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
