package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.bookstore.entity.Category;

/**
 * Servlet Filter implementation class CustomerLoginFilter
 */
@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CustomerLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	
		
		HttpServletRequest httRequest= (HttpServletRequest) request;
		
		HttpSession session = httRequest.getSession(false);
		String path = httRequest.getRequestURI().substring(httRequest.getContextPath().length());

		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		
		boolean loggedIn=session!=null && session.getAttribute("loggedCustomer")!=null;
		
		if(!loggedIn && path.startsWith("/view_prfile"))
		{
			String loginPage="frontend/login.jsp";
			RequestDispatcher dispatcher= httRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(httRequest, response);
		}
		else
		{
			chain.doFilter(request, response);
		}

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
