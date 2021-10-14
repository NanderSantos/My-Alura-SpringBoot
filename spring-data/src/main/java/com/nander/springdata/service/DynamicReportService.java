package com.nander.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nander.springdata.action.ReportAction;
import com.nander.springdata.orm.Employee;
import com.nander.springdata.repository.EmployeeRepository;
import com.nander.springdata.specifications.EmployeeSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DynamicReportService {

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
		actions.add(new ReportAction(0, "Sair", DynamicReportService::quit));
		actions.add(new ReportAction(1, "Buscar Funcionários", DynamicReportService::find));

		while (keepKunning) {

			System.out.println("Qual ação de Relatório Dinâmico você gostaria de executar?\n");
			actions.forEach(System.out::println);
			System.out.print("\n> ");

			int action = this.scanner.nextInt();
			if (this.scanner.hasNextLine())
				this.scanner.nextLine();
			System.out.println();

			actions.forEach(a -> {

				if (a.getId() == action) {
					keepKunning = a.getAction().apply(scanner, this.employeeRepository);
				}
			});
		}
	}

	public static Boolean quit(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Saindo das ações de Relatório...\n");
		return false;
	}

	public static Boolean find(Scanner scanner, EmployeeRepository employeeRepository) {

		System.out.println("Nome aproximado do Funcionário para buscar (Digite NULL para ignorar este filtro):");
		System.out.print("\n> ");
		String name = scanner.nextLine();
		if (name.equalsIgnoreCase("NULL"))
			name = null;
		System.out.println();

		System.out.println("CPF do Funcionário para buscar (Digite NULL para ignorar este filtro):");
		System.out.print("\n> ");
		String cpf = scanner.nextLine();
		if (cpf.equalsIgnoreCase("NULL"))
			cpf = null;
		System.out.println();

		System.out.println("Mínimo Salário do Funcionário para buscar (Digite 0 para ignorar este filtro):");
		System.out.print("\n> ");
		Double salary = scanner.nextDouble();
		if (scanner.hasNextLine())
			scanner.nextLine();
		if (salary == 0)
			salary = null;
		System.out.println();

		System.out.println(
				"Mínima Data de Contratação do Funcionário para buscar (Digite NULL para ignorar este filtro):");
		System.out.print("\n> ");
		String hiringDateStr = scanner.nextLine();
		LocalDate hiringDate = null;
		if (!hiringDateStr.equalsIgnoreCase("NULL"))
			hiringDate = LocalDate.parse(hiringDateStr, DynamicReportService.FORMATTER);
		System.out.println();

		System.out.println("Número da página que deseja visualizar:");
		System.out.print("\n> ");
		int pageNumber = scanner.nextInt() - 1;
		if (scanner.hasNextLine())
			scanner.nextLine();
		System.out.println();

		Page<Employee> employees = employeeRepository.findAll(
				Specification.where(
					EmployeeSpecification
						.name("%" + name + "%")
						.or(EmployeeSpecification.cpf(cpf))
						.or(EmployeeSpecification.salary(salary))
						.or(EmployeeSpecification.hiringDate(hiringDate))
				),
				PageRequest.of(pageNumber, 4, Sort.unsorted()));

		if (employees.getTotalElements() > 0) {

			employees.forEach(System.out::println);
			System.out.println();
			System.out.println("Página " + (employees.getNumber() + 1) + " de " + employees.getTotalPages() + "\n");

		} else
			System.out.println("Nenhum Funcionário encontrado!\n");

		return true;
	}
}