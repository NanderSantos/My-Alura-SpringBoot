package com.nander.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.nander.springdata.action.EmployeeAction;
import com.nander.springdata.orm.Employee;
import com.nander.springdata.orm.Position;
import com.nander.springdata.orm.WorkUnit;
import com.nander.springdata.repository.EmployeeRepository;
import com.nander.springdata.repository.PositionRepository;
import com.nander.springdata.repository.WorkUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCrudService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private WorkUnitRepository workUnitRepository;

	private Scanner scanner;
	private Boolean keepKunning;

	public void init(Scanner scanner) {

		this.keepKunning = true;
		this.scanner = scanner;

		List<EmployeeAction> actions = new ArrayList<>();
		actions.add(new EmployeeAction(0, "Sair", EmployeeCrudService::quit));
		actions.add(new EmployeeAction(1, "Salvar", EmployeeCrudService::save));
		actions.add(new EmployeeAction(2, "Atualizar", EmployeeCrudService::update));
		actions.add(new EmployeeAction(3, "Visualizar", EmployeeCrudService::list));
		actions.add(new EmployeeAction(4, "Deletar", EmployeeCrudService::delete));

		while (keepKunning) {

			System.out.println("Qual ação de Funcionário você gostaria de executar?\n");
			actions.forEach(System.out::println);
			System.out.print("\n> ");

			int action = this.scanner.nextInt();
			if(this.scanner.hasNextLine()) this.scanner.nextLine();
			System.out.println();

			actions.forEach(a -> { 
				
				if(a.getId() == action) {
					keepKunning = a.getAction().apply(
						scanner, 
						this.employeeRepository,
						this.positionRepository,
						this.workUnitRepository
					);
				}
			});
		}
	}

	public static Boolean quit(Scanner scanner, EmployeeRepository employeeRepository, PositionRepository positionRepository, WorkUnitRepository workUnitRepository) {

		System.out.println("Saindo das ações de Funcionário...\n");
		return false;
	}

	public static Boolean save(Scanner scanner, EmployeeRepository employeeRepository, PositionRepository positionRepository, WorkUnitRepository workUnitRepository) {

		System.out.println("Nome do Funcionário:");
		System.out.print("\n> ");
		String name = scanner.nextLine();
		System.out.println();

		System.out.println("CPF do Funcionário:");
		System.out.print("\n> ");
		String cpf = scanner.nextLine();
		System.out.println();

		System.out.println("Salário do Funcionário (Utilize ',' para representar o valor decimal):");
		System.out.print("\n> ");
		Double salary = scanner.nextDouble();
		System.out.println();

		String hiringDate = LocalDate.now().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Position position = getPosition(scanner, positionRepository);
		List<WorkUnit> workUnits = getWorkUnits(scanner, workUnitRepository);

		Employee employee = new Employee();
		employee.setName(name);
		employee.setCpf(cpf);
		employee.setSalary(salary);
		employee.setHiringDate(LocalDate.parse(hiringDate, formatter));
		employee.setPosition(position);
		employee.setWorkUnits(workUnits);

		employeeRepository.save(employee);

		System.out.println("Salvo!\n");

		return true;
	}

	private static List<WorkUnit> getWorkUnits(Scanner scanner, WorkUnitRepository workUnitRepository) {
		
		List<WorkUnit> workUnits = new ArrayList<>();
		Integer workUnitId = 0;
		
		while(workUnitId == 0) {

			System.out.println("Digite o ID corresponde à Unidade de Trabalho do Funcionário ou 0 para sair:\n");
			WorkUnitCrudService.list(scanner, workUnitRepository);
			System.out.print("> ");
			workUnitId = scanner.nextInt();
			if(scanner.hasNextLine()) scanner.nextLine();
			System.out.println();

			if(workUnitId != 0) {

				Optional<WorkUnit> optionalWorkUnit = workUnitRepository.findById(workUnitId);
				workUnitId = optionalWorkUnit.isPresent() ? workUnitId : 0;
	
				if(workUnitId != 0) {

					workUnits.add(optionalWorkUnit.get());
					workUnitId = 0;

					System.out.println("Unidade de trabalho adicionada!\n");

				} else System.out.println("Unidade de trabalho não encontrada!");

			} else break;
		}
		
		return workUnits;
	}

	private static Position getPosition(Scanner scanner, PositionRepository positionRepository) {	

		Integer positionId = 0;
		
		while(positionId == 0) {

			System.out.println("Digite o ID corresponde ao Cargo do Funcionário:\n");
			PositionCrudService.list(scanner, positionRepository);
			System.out.print("> ");
			positionId = scanner.nextInt();
			System.out.println();

			Optional<Position> optionalPosition = positionRepository.findById(positionId);
			positionId = optionalPosition.isPresent() ? positionId : 0;

			if(positionId == 0) System.out.println("Cargo não encontrado!");
		}

		Optional<Position> optionalPosition = positionRepository.findById(positionId);

		return optionalPosition.get();
	}

	public static Boolean update(Scanner scanner, EmployeeRepository employeeRepository, PositionRepository positionRepository, WorkUnitRepository workUnitRepository) {

		System.out.println("Id do Funcionário para ser atualizado:");
		System.out.print("\n> ");
		int employeeId = scanner.nextInt();
		if(scanner.hasNextLine()) scanner.nextLine();
		System.out.println();

		Optional<Employee> optional = employeeRepository.findById(employeeId);

		if(optional.isPresent()) {

			System.out.println("Nome do Funcionário:");
			System.out.print("\n> ");
			String name = scanner.nextLine();
			System.out.println();

			System.out.println("CPF do Funcionário:");
			System.out.print("\n> ");
			String cpf = scanner.nextLine();
			System.out.println();

			System.out.println("Salário do Funcionário (Utilize ',' para representar o valor decimal):");
			System.out.print("\n> ");
			Double salary = scanner.nextDouble();
			System.out.println();
			
			Position position = getPosition(scanner, positionRepository);
			List<WorkUnit> workUnits = getWorkUnits(scanner, workUnitRepository);

			Employee employee = optional.get();
			employee.setName(name);
			employee.setCpf(cpf);
			employee.setSalary(salary);
			employee.setPosition(position);
			employee.setWorkUnits(workUnits);

			employeeRepository.save(employee);

			System.out.println("Salvo!\n");

		} else {

			System.out.println("Funcionário não encontrado!\n");
		}

		return true;
	}

	public static Boolean list(Scanner scanner, EmployeeRepository employeeRepository, PositionRepository positionRepository, WorkUnitRepository workUnitRepository) {

		System.out.println("Número da página que deseja visualizar:");
		System.out.print("\n> ");
		int pageNumber = scanner.nextInt() - 1;
		if(scanner.hasNextLine()) scanner.nextLine();
		System.out.println();

		Pageable pageable = PageRequest.of(pageNumber, 4, Sort.by(Sort.Direction.DESC, "name"));
		Page<Employee> page = employeeRepository.findAll(pageable);

		if(page.iterator().hasNext()) {

			page.forEach(System.out::println);
			System.out.println();
			System.out.println("Página " + (page.getNumber() + 1) + " de " + page.getTotalPages() + "\n");
		
		} else System.out.println("Nenhum Funcionário cadastrado ainda!\n");

		return true;
	}

	public static Boolean delete(Scanner scanner, EmployeeRepository employeeRepository, PositionRepository positionRepository, WorkUnitRepository workUnitRepository) {

		System.out.println("Id do Funcionário para ser deletado:");
		System.out.print("\n> ");
		int id = scanner.nextInt();
		System.out.println();

		Optional<Employee> optional = employeeRepository.findById(id);

		if(optional.isPresent()) {

			employeeRepository.deleteById(id);
			System.out.println("Funcionário Deletado!\n");

		} else {

			System.out.println("Funcionário não encontrado!\n");
		}

		return true;
	}
}