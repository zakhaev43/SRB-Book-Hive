package com.bookstore.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest  extends BaseDAOTest{
	
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		BaseDAOTest.setUpBeforeClass();
		categoryDAO= new CategoryDAO(entityManager);
	}

	public static void tearDownAfterClass() throws Exception {
		
		BaseDAOTest.tearDownAfterClass();
	}


	@Test
	public void testCreateCategory() {

   Category newcat = new Category("Health");
   Category category= categoryDAO.create(newcat);
   assertTrue(category!=null && category.getCategoryId()>0);
	}
	@Test
	public void testUpdateCategory() {

   Category cat = new Category("Java Core");
   cat.setCategoryId(1);
  Category category= categoryDAO.update(cat);
   
   assertEquals(cat.getName(),category.getName());
	}
	@Test
	public void testGet() {
		int catId=28;
		Category cat= categoryDAO.get(catId);
		assertNotNull(cat);
	}

	@Test
	public void testDeleteObject() {
		
		int catId=2;
		categoryDAO.delete(catId);
		Category cat= categoryDAO.get(catId);
		assertNull(cat);
	}

	@Test
	public void testListAll() {
		
		
	List<Category> listcat = categoryDAO.listAll();
	assertTrue(listcat.size()==3);
	}

	@Test
	public void testCount() {
		
		int tod= (int) categoryDAO.count();
		System.out.println(tod);
		assertEquals(3, tod);
	}

}
