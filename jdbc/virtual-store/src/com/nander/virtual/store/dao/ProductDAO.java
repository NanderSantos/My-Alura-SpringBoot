package com.nander.virtual.store.dao;

public class ProductDAO {

	private Integer id;
	private String name;
	private String description;

	private CategoryDAO category;
	
	public ProductDAO(String name, String description) {

		this.name = name;
		this.description = description;
	}
	
	public ProductDAO(Integer id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		
		return "{ id: " + this.id + ", name: \"" + this.name + "\", description: \"" + this.description+ "\", category: \"" + this.category.getId() + "\" }";
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

	public String getDescription() {
		return description;
	}

	public CategoryDAO getCategory() {
		return category;
	}

	public void setCategory(CategoryDAO category) {

		this.category = category;
	}
}
