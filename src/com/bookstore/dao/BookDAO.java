package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Book;
import com.bookstore.entity.Users;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO(EntityManager entityManager) {
		super(entityManager);

	}

	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);

	}

	public Book update(Book book) {
		Date lastUpdateTime = new Date();
		book.setLastUpdateTime(lastUpdateTime);
		return super.update(book);

	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookid) {
		super.delete(Book.class, bookid);

	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.findAll");

	}

	public Book findByTitle(String title) {
		List<Book> result = findWithNamedQuery("Book.findByTitle", "title", title);
		if (!result.isEmpty()) {
			Book book = result.get(0);
			return book;
		} else {
			return null;
		}

	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}

}