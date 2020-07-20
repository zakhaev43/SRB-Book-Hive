package com.bookstore.controller.admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;

/**
 * Servlet implementation class BeseServlet
 */
@WebServlet("/")
public abstract class BaseServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	//protected CategoryDAO categoryDAO;
	//protected HttpServletRequest request;
	//protected HttpServletResponse response;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}
	@Override
	public void destroy() {


		entityManager.close();
		entityManagerFactory.close();
	}
	

}
