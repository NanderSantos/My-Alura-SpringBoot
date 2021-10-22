package br.com.alura.gerenciador.model;

import java.util.Date;

public class Company {

	private int id;
	private String name;
	private Date creationDate = new Date();

	@Override
	public String toString() {

		return this.id + " - Nome: " + this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
