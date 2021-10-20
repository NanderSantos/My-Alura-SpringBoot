package com.nander.virtual.store.dao;

public class ProductDAO {

	private Integer id;
	private String name;
	private String description;
	
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
		
		return "Produto: { id: " + this.id + ", name: \"" + this.name + "\", description: \"" + this.description + "\" }";
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
}
