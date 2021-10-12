package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ProductDAO;
import com.simplilearn.model.Product;

/**
 * Servlet implementation class RetrieveServlet
 */
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetrieveServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO prodDAO = new ProductDAO();

		prodDAO.initializeConnection();
		List<Product> productList = prodDAO.retrieveProductDetails();

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for(Product eachProduct : productList) {
			out.println("<br>Id :- "+ eachProduct.getProductId() +", Name :-"+ eachProduct.getProductName() 
						+ ", Quantity In Stock:- "+ eachProduct.getQuantityInStock() + ", Price:- "+ eachProduct.getUnitPrice());
		}
		
		out.println("</body></html>");
		prodDAO.closeSession();
	}

}
