package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest {
	
	
	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		customerDAO= new CustomerDAO();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setEmail("customer11@gmail.com");
		customer.setFullName("Peter");
		
		customer.setCity("New York");
		
		customer.setCountry("United States");
		customer.setAddress("100 North Avenue");
	
		customer.setPassword("secret");
		customer.setPhone("18001900");
		customer.setZipcode("100000");
		
		Customer savedCustomer = customerDAO.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
		
		
	}

	@Test
	public void testGet() {
	Integer customerId=1;
	Customer customer= customerDAO.get(customerId);
	assertNotNull(customer);
	}

	@Test 
	public void testUpdateCustomer()
	{
		Customer customer= customerDAO.get(1);
		customer.setFullName("Taqi Usmani");
		String fullName= "Taqi Usmani";
		Customer updatedCustomer=customerDAO.update(customer);
		assertTrue(updatedCustomer.getFullName().equals(fullName));
	}
	
	@Test
	public void testDeleteObject() {
	
		
		Integer customerId = 1;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(customerId);
		
		assertNull(customer);	
		
	}
	@Test
	public void testlistAll()
	{
		List<Customer> listCustomers= customerDAO.listAll();
		
		assertFalse(listCustomers.isEmpty());
	}
	@Test
	public void testCount() {
		long totalCustomers = customerDAO.count();
		
		assertEquals(1, totalCustomers);
		
	}
	@Test
	public void testFindByEmail() {
		String email = "customer11@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email="imransuet@gmail.com";
		String password="123";
		Customer customer= customerDAO.checkLogin(email, password);
		assertNotNull(customer);
		
	}
	
	
	
	
}
