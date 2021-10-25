package br.com.alura.gerenciador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.User;

public class DatabaseService {
	
	private static List<Company> companies = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Integer sequentialKey = 1;
	
	static {
		
		Company company1 = new Company();
		company1.setName("Alura");
		company1.setId(DatabaseService.sequentialKey++);
		
		Company company2 = new Company();
		company2.setName("Caelum");
		company2.setId(DatabaseService.sequentialKey++);
		
		companies.add(company1);
		companies.add(company2);
		
		User u1 = new User();
		u1.setLogin("nico");
		u1.setPassword("123456");
		
		User u2 = new User();
		u2.setLogin("ana");
		u2.setPassword("123456");
		
		users.add(u1);
		users.add(u2);
	}

	public void addCompany(Company company) {
		
		company.setId(DatabaseService.sequentialKey++);
		companies.add(company);
	}

	public static List<Company> getCompanies() {
		return DatabaseService.companies;
	}

	public void deleteCompany(Integer id) {
		
		DatabaseService.companies.removeIf(company -> company.getId() == id);		
	}

	public Company findById(Integer id) {
		
		Optional<Company> optional = DatabaseService.companies
				.stream()
				.filter(company -> company.getId() == id)
				.findFirst();
		
		if(optional.isPresent()) return optional.get();
		else return null;
	}

	public User searchUser(String login, String password) {

		Optional<User> optional = DatabaseService.users
				.stream()
				.filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
				.findFirst();
		
		if(optional.isPresent()) return optional.get();
		else return null;
	}
}
