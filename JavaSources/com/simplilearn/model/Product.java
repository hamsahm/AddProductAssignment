package com.simplilearn.model;

public class Product {

	private long productId;
	private String productName;
	private long quantityInStock;
	private long unitPrice;

	public Product() {
		super();
	}

	public Product(String productName, long quantityInStock, long unitPrice) {
		this.productName = productName;
		this.quantityInStock = quantityInStock;
		this.unitPrice = unitPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

}
