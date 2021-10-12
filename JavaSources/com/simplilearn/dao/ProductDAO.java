package com.simplilearn.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.model.Product;

public class ProductDAO {

	Session session;

	public void initializeConnection() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		this.session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");
	}

	public Long addProductDetails(HttpServletRequest request) {

		// Fetch the product details from request
		String productName = request.getParameter("productName");
		long quantity = 0;
		long unitPrice = 0;
		try {
			quantity = Long.valueOf(request.getParameter("quantity"));
			unitPrice = Long.valueOf(request.getParameter("unitPrice"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// Call product constructor to initialise the values
		Product product = new Product(productName, quantity, unitPrice);

		session.beginTransaction();

		Long stId = (Long) session.save(product);
		session.getTransaction().commit();
		return stId;
	}

	public List<Product> retrieveProductDetails() {

		String hibernateQuery = "select p from Product p";
		List<Product> productList = session.createQuery(hibernateQuery, Product.class).getResultList();

		return productList;
	}

	public void closeSession() {
		System.out.println("Hibernate Session closed!");
		session.close();
	}
}
