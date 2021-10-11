package com.nander.springdata;

import com.nander.springdata.orm.Position;
import com.nander.springdata.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private PositionRepository positionRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Position position = new Position();
		position.setDescription("SOFTWARE DEVELOPER");
		this.positionRepository.save(position);
	}
}
