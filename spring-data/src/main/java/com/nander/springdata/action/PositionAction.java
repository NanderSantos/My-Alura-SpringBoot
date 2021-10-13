package com.nander.springdata.action;

import java.util.Scanner;
import java.util.function.BiFunction;

import com.nander.springdata.repository.PositionRepository;

public class PositionAction {
	
	private int id;
	private String name;
	private BiFunction<Scanner, PositionRepository, Boolean> action;

	public PositionAction(int id, String name, BiFunction<Scanner, PositionRepository, Boolean> action) {

		this.id = id;
		this.name = name;
		this.action = action;
	}

	@Override
	public String toString() {

		return this.id + " - " + this.name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BiFunction<Scanner, PositionRepository, Boolean> getAction() {
		return action;
	}
}
