package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	
	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao= new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	
	@Test
	public void testCreateReview() {
		
		Review review = new Review();
		Book book = new Book();
		book.setBookId(30);
		
		Customer customer = new Customer();
		customer.setCustomerId(2);
		
		review.setBook(book);
		review.setCustomer(customer);
		
		review.setHeadline("Earliest resource for Fiqh");
		review.setRating(5);
		review.setComment("This is one of the earliest resource of fiqh, highly recommended for scholory usage, not for layman");
		
		Review savedReview = reviewDao.create(review);
		
		assertTrue(savedReview.getReviewId() > 0);
		
	}

	@Test
	public void testUpdateReview() {
		
		Integer reviewId=1;
		Review review= reviewDao.get(reviewId);
		review.setHeadline("Best Books on fiqh");
		Review updaReview= reviewDao.update(review);
		assertEquals(review.getHeadline(), updaReview.getHeadline());
	}

	@Test
	public void testGet() {
		
		Integer reviewId=1;
		Review review= reviewDao.get(reviewId);
		assertNull(review);
		
	}

	@Test
	public void testDeleteReview() {
		
		int reviewId=1;
		reviewDao.delete(reviewId);
		
		Review review= reviewDao.get(reviewId);
		assertNull(review);
	}

	@Test
	public void testListAll() {
List<Review> listReview = reviewDao.listAll();
		
for (Review review : listReview) {
	System.out.println(review.getReviewId() + " - " + review.getBook().getTitle()
			+ " - " + review.getCustomer().getAddress()
			+ " - " + review.getHeadline() + " - " + review.getRating());
}
		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCount() {
		long totalReviews = reviewDao.count();
  System.out.println("Total Reviews: " + totalReviews);
		assertTrue(totalReviews > 0 );
	}
	
	@Test
	public void testFindByCustomerAndBook()
	{
		Integer customerId=2;
		Integer bookId=25;
		Review result= reviewDao.findByCustomerAndBook(customerId, bookId);
		assertNotNull(result);
		
	}
	

}
