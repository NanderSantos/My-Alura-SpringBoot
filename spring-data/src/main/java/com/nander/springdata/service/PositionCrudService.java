package com.nander.springdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.nander.springdata.orm.Position;
import com.nander.springdata.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionCrudService {

	@Autowired
	private PositionRepository positionRepository;

	private Scanner scanner;
	private Boolean keepKunning;

	public void init(Scanner scanner) {

		this.keepKunning = true;
		this.scanner = scanner;

		List<PositionAction> actions = new ArrayList<>();
		actions.add(new PositionAction(0, "Sair", PositionCrudService::quit));
		actions.add(new PositionAction(1, "Salvar", PositionCrudService::save));
		actions.add(new PositionAction(2, "Atualizar", PositionCrudService::update));
		actions.add(new PositionAction(3, "Visualizar", PositionCrudService::list));
		actions.add(new PositionAction(4, "Deletar", PositionCrudService::delete));

		while (keepKunning) {

			System.out.println("Qual ação de Cargo você gostaria de executar?\n");
			actions.forEach(System.out::println);
			System.out.print("\n> ");

			int action = this.scanner.nextInt();
			if(this.scanner.hasNextLine()) this.scanner.nextLine();
			System.out.println();

			actions.forEach(a -> { 
				
				if(a.getId() == action) {
					keepKunning = a.getAction().apply(scanner, this.positionRepository);
				}
			});
		}
	}

	public static Boolean quit(Scanner scanner, PositionRepository positionRepository) {

		System.out.println("Saindo das ações de Cargo...\n");
		return false;
	}

	public static Boolean save(Scanner scanner, PositionRepository positionRepository) {

		System.out.println("Descrição do Cargo:");
		System.out.print("\n> ");
		String description = scanner.nextLine();

		Position position = new Position();
		position.setDescription(description);

		positionRepository.save(position);

		System.out.println("\nSalvo!\n");

		return true;
	}

	public static Boolean update(Scanner scanner, PositionRepository positionRepository) {

		System.out.println("Id do Cargo para ser atualizado:");
		System.out.print("\n> ");
		int id = scanner.nextInt();
		System.out.println();

		Optional<Position> optional = positionRepository.findById(id);

		if(optional.isPresent()) {

			System.out.println("Nova descrição do Cargo:");
			System.out.print("\n> ");
			String description = scanner.nextLine();

			Position position = new Position();
			position.setId(id);
			position.setDescription(description);

			positionRepository.save(position);

			System.out.println("\nCargo Atualizado!\n");

		} else {

			System.out.println("\nCargo não encontrado!\n");
		}

		

		return true;
	}

	public static Boolean list(Scanner scanner, PositionRepository positionRepository) {

		Iterable<Position> positions = positionRepository.findAll();
		positions.forEach(System.out::println);
		System.out.println();

		return true;
	}

	public static Boolean delete(Scanner scanner, PositionRepository positionRepository) {

		System.out.println("Id do Cargo para ser deletado:");
		System.out.print("\n> ");
		int id = scanner.nextInt();
		System.out.println();

		Optional<Position> optional = positionRepository.findById(id);

		if(optional.isPresent()) {

			positionRepository.deleteById(id);
			System.out.println("Cargo Deletado!\n");

		} else {

			System.out.println("Cargo não encontrado!\n");
		}

		return true;
	}
}