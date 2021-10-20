package com.nander.virtual.store.dao;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	private Integer id;
	private String name;

	private List<ProductDAO> products = new ArrayList<>();
	
	public CategoryDAO(String name) {

		this.name = name;
	}
	
	public CategoryDAO(Integer id, String name) {

		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		
		return "{ id: " + this.id + ", name: \"" + this.name + "\", products: " + this.products + " }";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public List<ProductDAO> getProducts() {
		return products;
	}

	public void addProduct(ProductDAO product) {

		product.setCategory(this);
		this.products.add(product);
	}
}
