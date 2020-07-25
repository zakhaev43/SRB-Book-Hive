package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest {
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDao = new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();

	}

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existBook = new Book();
		existBook.setBookId(1);

		Category category = new Category("Java Core");
		category.setCategoryId(1);

		existBook.setCategory(category);

		existBook.setTitle("Effective Java (3th Edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription("New coverage of generics, enums, annotations.");
		existBook.setPrice(40F);
		existBook.setIsbn("0321356683");

		DateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormater.parse("05/28/2008");
		existBook.setPublishDate(publishDate);


		String imagePath = "C:\\Users\\Saifur Rahman\\3D Objects\\a.jpg";   
		byte[] readedBytes = Files.readAllBytes(Paths.get(imagePath));

		existBook.setImage(readedBytes);

		Book updatedBook = bookDao.update(existBook);
		assertEquals(existBook.getTitle(), "Effective Java (3th Edition)");

	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();

		Category category = new Category("Advanced Java");
		category.setCategoryId(1);

		newBook.setCategory(category);

		newBook.setTitle("Effective Java (2nd Edition)");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription("New coverage of generics, enums, annotations.");
		newBook.setPrice(38.37F);
		newBook.setIsbn("0321356683");

		DateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormater.parse("05/28/2008");
		newBook.setPublishDate(publishDate);

		
		String imagePath = "C:\\Users\\Saifur Rahman\\3D Objects\\a.jpg";                                                                
		
		byte[] readedBytes = Files.readAllBytes(Paths.get(imagePath));

		newBook.setImage(readedBytes);

		Book createdBook = bookDao.create(newBook);
		assertTrue(createdBook.getBookId() > 0);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDao.delete(bookId);
	}

	@Test
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDao.get(bookId);

		assertNull(book);
	}

	@Test
	public void testListBook() {
		List<Book> listAll = bookDao.listAll();

		assertFalse(listAll.isEmpty());
	}
	
	@Test
	public void testCreate2ndBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		newBook.setCategory(category);
		
		newBook.setTitle("Java 8 in Action");
		newBook.setAuthor("Alan Mycroft");
		newBook.setDescription("Java 8 in Action is a clearly written guide to the new features of Java 8");
		newBook.setPrice(36.72f);
		newBook.setIsbn("1617291994");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
		Date publishDate = dateFormat.parse("08/28/2014");
		newBook.setPublishDate(publishDate);
		
		String imagePath = "D:\\BookStoreProject\\dummy-data\\books\\Java 8 in Action.JPG";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newBook);
		
		assertTrue(createdBook.getBookId() > 0);
	}
	
	@Test
	public void testFindByTitleNotExist() {
		String title = "Thinkin in Java";
		Book book = bookDao.findByTitle(title);
		
		assertNull(book);
	}
	
	@Test
	public void testFindByTitleExist() {
		String title = "Java 8 in Action";
		Book book = bookDao.findByTitle(title);
		
		System.out.println(book.getAuthor());
		System.out.println(book.getPrice());
		
		assertNotNull(book);
		
	}

}