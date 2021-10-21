package br.com.alura.gerenciador.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Company;

public class Database {
	
	private static List<Company> companies = new ArrayList<>();
	
	static {
		
		Company company1 = new Company();
		company1.setName("Alura");
		company1.setId(1);
		
		Company company2 = new Company();
		company2.setName("Caelum");
		company2.setId(2);
		
		companies.add(company1)	;
		companies.add(company2);
	}

	public void addCompany(Company company) {
		
		company.setId(companies.size() + 1);
		companies.add(company);
	}

	public static List<Company> getCompanies() {
		return Database.companies;
	}
}
