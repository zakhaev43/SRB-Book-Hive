package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
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
	public void testCreateBook() throws ParseException, IOException {

		Book newBook = new Book();

		Category category = new Category("Java EE");
		category.setCategoryId(3);
		newBook.setCategory(category);

		newBook.setTitle("Effective Java (2nd Edition)");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		newBook.setPrice(38.87f);
		newBook.setIsbn("0321356683");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishDate(publishDate);

		String imagePath = "C:\\Users\\Saifur Rahman\\3D Objects\\48094339n.JPG";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);             

		Book createdBook = bookDao.create(newBook);

		assertTrue(createdBook.getBookId() > 0);
	}

}
