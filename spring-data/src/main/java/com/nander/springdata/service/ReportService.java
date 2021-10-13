package com.nander.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nander.springdata.action.ReportAction;
import com.nander.springdata.orm.Employee;
import com.nander.springdata.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Scanner scanner;
	private Boolean keepKunning;

	private final static String FORMAT = "dd/MM/yyyy";
	private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

	public void init(Scanner scanner) {

		this.keepKunning = true;
		this.scanner = scanner;

		List<ReportAction> actions = new ArrayList<>();
		actions.add(new ReportAction(0, "Sair", ReportService::quit));
		actions.add(new ReportAction(1, "Buscar Funcionários por Nome", ReportService::findByName));
		actions.add(new ReportAction(2, "Buscar Funcionários por aproximação do Nome", ReportService::findByNameLike));
		actions.add(new ReportAction(3, "Buscar Funcionários por Nome, Salário e Data de Contratação", ReportService::findByNameSalaryHiringDate));
		actions.add(new ReportAction(4, "Buscar Funcionários contratados a partir de um certo dia", ReportService::findByHiringDateGrather));

		while (keepKunning) {

			System.out.println("Qual ação de Relatório você gostaria de executar?\n");
			actions.forEach(System.out::println);
			System.out.print("\n> ");

			int action = this.scanner.nextInt();
			if(this.scanner.hasNextLine()) this.scanner.nextLine();
			System.out.println();

			actions.forEach(a -> { 
				
				if(a.getId() == action) {
					keepKunning = a.getAction().apply(scanner, this.employeeRepository);
				}
			});
		}
	}

	public static Boolean quit(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Saindo das ações de Relatório...\n");
		return false;
	}

	public static Boolean findByName(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Nome do Funcionário para Buscar:");
		System.out.print("\n> ");
		String name = scanner.nextLine();
		System.out.println();

		List<Employee> employees = employeeRepository.findByName(name);
		
		if(employees.size() > 0) {

			employees.forEach(System.out::println);
			System.out.println();
		
		} else System.out.println("Nenhum Funcionário encontrado!\n");

		return true;
	}

	public static Boolean findByNameLike(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Nome aproximado do Funcionário para buscar:");
		System.out.print("\n> ");
		String name = scanner.nextLine();
		System.out.println();

		System.out.println("Número da página que deseja visualizar:");
		System.out.print("\n> ");
		int pageNumber = scanner.nextInt() - 1;
		if(scanner.hasNextLine()) scanner.nextLine();
		System.out.println();

		Pageable pageable = PageRequest.of(pageNumber, 4, Sort.unsorted());
		Page<Employee> page = employeeRepository.findAll(pageable);

		List<Employee> employees = employeeRepository.findByNameLike("%" + name + "%", pageable);
		
		if(employees.size() > 0) {

			employees.forEach(System.out::println);
			System.out.println();
			System.out.println("Página " + (page.getNumber() + 1) + " de " + page.getTotalPages() + "\n");
		
		} else System.out.println("Nenhum Funcionário encontrado!\n");

		return true;
	}

	public static Boolean findByNameSalaryHiringDate(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Nome do Funcionário para buscar:");
		System.out.print("\n> ");
		String name = scanner.nextLine();
		System.out.println();

		System.out.println("Valor mínimo de salário para buscar:");
		System.out.print("\n> ");
		Double salary = scanner.nextDouble();
		if(scanner.hasNextLine()) scanner.nextLine();
		System.out.println();

		System.out.println("Data de contratação para buscar (" + ReportService.FORMAT + "):");
		System.out.print("\n> ");
		String hiringDate = scanner.nextLine();
		System.out.println();

		List<Employee> employees = employeeRepository.findByNameHiringDateSalaryGreather(
			name,
			salary,
			LocalDate.parse(hiringDate, ReportService.FORMATTER)
		);
		
		if(employees.size() > 0) {

			employees.forEach(System.out::println);
			System.out.println();
		
		} else System.out.println("Nenhum Funcionário encontrado!\n");

		return true;
	}

	public static Boolean findByHiringDateGrather(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Mínima data de contratação para buscar (" + ReportService.FORMAT + "):");
		System.out.print("\n> ");
		String hiringDate = scanner.nextLine();
		System.out.println();

		List<Employee> employees = employeeRepository.findByHiringDateGrather(
			LocalDate.parse(hiringDate, ReportService.FORMATTER)
		);
		
		if(employees.size() > 0) {

			employees.forEach(System.out::println);
			System.out.println();
		
		} else System.out.println("Nenhum Funcionário encontrado!\n");

		return true;
	}
}