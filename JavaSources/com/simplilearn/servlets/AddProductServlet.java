package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ProductDAO;

/**
 * Servlet implementation class RetrieveServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAO prodDAO = new ProductDAO();

		prodDAO.initializeConnection();
		Long transactionId = prodDAO.addProductDetails(request);
		response.getWriter().println("Product details added successfully. The product id is " + transactionId);

		prodDAO.closeSession();
	}

}
