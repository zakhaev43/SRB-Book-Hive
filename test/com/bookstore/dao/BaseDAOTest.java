package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;

public class BaseDAOTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	protected static CategoryDAO categoryDAO;
	
public static void setUpBeforeClass() throws Exception {
		
		entityManagerFactory= Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager= entityManagerFactory.createEntityManager();
		
	}

@AfterClass
public static void tearDownAfterClass() throws Exception {
	
	entityManager.close();
	entityManagerFactory.close();
}


}
