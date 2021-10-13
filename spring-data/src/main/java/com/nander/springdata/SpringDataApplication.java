package com.nander.springdata;

import java.util.Scanner;

import com.nander.springdata.service.EmployeeCrudService;
import com.nander.springdata.service.PositionCrudService;
import com.nander.springdata.service.ReportService;
import com.nander.springdata.service.WorkUnitCrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean keepRunning = true;

	@Autowired
	private PositionCrudService positionService;

	@Autowired
	private WorkUnitCrudService workUnitService;

	@Autowired
	private EmployeeCrudService employeeService;

	@Autowired
	private ReportService reportService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println();

		while (keepRunning) {

			System.out.println("Qual ação você gostaria de executar?\n");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade de Trabalho");
			System.out.println("3 - Funcionário");
			System.out.println("4 - Relatório");
			System.out.print("\n> ");

			int action = scanner.nextInt();
			System.out.println();

			switch (action) {

				case 1:

					positionService.init(scanner);
					break;

				case 2:

					workUnitService.init(scanner);
					break;

				case 3:

					employeeService.init(scanner);
					break;

				case 4:

					reportService.init(scanner);
					break;

				default:

					System.out.println("Encerrando a aplicação...\n");
					keepRunning = false;
					break;
			}
		}
	}
}
