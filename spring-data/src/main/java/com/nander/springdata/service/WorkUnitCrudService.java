package com.nander.springdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.nander.springdata.action.WorkUnitAction;
import com.nander.springdata.orm.WorkUnit;
import com.nander.springdata.repository.WorkUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkUnitCrudService {

	@Autowired
	private WorkUnitRepository workUnitRepository;

	private Scanner scanner;
	private Boolean keepKunning;

	public void init(Scanner scanner) {

		this.keepKunning = true;
		this.scanner = scanner;

		List<WorkUnitAction> actions = new ArrayList<>();
		actions.add(new WorkUnitAction(0, "Sair", WorkUnitCrudService::quit));
		actions.add(new WorkUnitAction(1, "Salvar", WorkUnitCrudService::save));
		actions.add(new WorkUnitAction(2, "Atualizar", WorkUnitCrudService::update));
		actions.add(new WorkUnitAction(3, "Visualizar", WorkUnitCrudService::list));
		actions.add(new WorkUnitAction(4, "Deletar", WorkUnitCrudService::delete));

		while (keepKunning) {

			System.out.println("Qual ação de Unidade de Trabalho você gostaria de executar?\n");
			actions.forEach(System.out::println);
			System.out.print("\n> ");

			int action = this.scanner.nextInt();
			if(this.scanner.hasNextLine()) this.scanner.nextLine();
			System.out.println();

			actions.forEach(a -> {

				if (a.getId() == action) {
					keepKunning = a.getAction().apply(scanner, this.workUnitRepository);
				}
			});
		}
	}

	public static Boolean quit(Scanner scanner, WorkUnitRepository workUnitRepository) {

		System.out.println("Saindo das ações de Unidade de Trabalho...\n");
		return false;
	}

	public static Boolean save(Scanner scanner, WorkUnitRepository workUnitRepository) {

		System.out.println("Descrição da Unidade de Trabalho:");
		System.out.print("\n> ");
		String description = scanner.nextLine();
		System.out.println();

		System.out.println("Endereço da Unidade de Trabalho:");
		System.out.print("\n> ");
		String address = scanner.nextLine();

		WorkUnit workUnit = new WorkUnit();
		workUnit.setDescription(description);
		workUnit.setAddress(address);

		workUnitRepository.save(workUnit);

		System.out.println("\nSalva!\n");

		return true;
	}

	public static Boolean update(Scanner scanner, WorkUnitRepository workUnitRepository) {

		System.out.println("Id da Unidade de Trabalho para ser atualizada:");
		System.out.print("\n> ");
		int id = scanner.nextInt();
		if(scanner.hasNextLine()) scanner.nextLine();
		System.out.println();

		Optional<WorkUnit> optional = workUnitRepository.findById(id);

		if (optional.isPresent()) {

			System.out.println("Nova descrição da Unidade de Trabalho:");
			System.out.print("\n> ");
			String description = scanner.nextLine();
			System.out.println();

			System.out.println("Novo endereço da Unidade de Trabalho:");
			System.out.print("\n> ");
			String address = scanner.nextLine();

			WorkUnit workUnit = new WorkUnit();
			workUnit.setId(id);
			workUnit.setDescription(description);
			workUnit.setAddress(address);

			workUnitRepository.save(workUnit);
			System.out.println("\nUnidade de Trabalho Atualizada!\n");

		} else {

			System.out.println("Unidade de Trabalho não encontrada!\n");
		}

		return true;
	}

	public static Boolean list(Scanner scanner, WorkUnitRepository workUnitRepository) {

		Iterable<WorkUnit> workUnits = workUnitRepository.findAll();

		if(workUnits.iterator().hasNext()) {

			workUnits.forEach(System.out::println);
			System.out.println();
		
		} else System.out.println("Nenhuma Unidade de Trabalho cadastrada ainda!\n");

		return true;
	}

	public static Boolean delete(Scanner scanner, WorkUnitRepository workUnitRepository) {

		System.out.println("Id da Unidade de Trabalho para ser deletada:");
		System.out.print("\n> ");
		int id = scanner.nextInt();
		System.out.println();

		Optional<WorkUnit> optional = workUnitRepository.findById(id);

		if (optional.isPresent()) {

			workUnitRepository.deleteById(id);
			System.out.println("Unidade de Trabalho Deletada!\n");

		} else {

			System.out.println("Unidade de Trabalho não encontrada!\n");
		}

		return true;
	}
}