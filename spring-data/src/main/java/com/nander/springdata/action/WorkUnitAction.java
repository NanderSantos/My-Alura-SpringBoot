package com.nander.springdata.action;

import java.util.Scanner;
import java.util.function.BiFunction;

import com.nander.springdata.repository.WorkUnitRepository;

public class WorkUnitAction {
	
	private int id;
	private String name;
	private BiFunction<Scanner, WorkUnitRepository, Boolean> action;

	public WorkUnitAction(int id, String name, BiFunction<Scanner, WorkUnitRepository, Boolean> action) {

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

	public BiFunction<Scanner, WorkUnitRepository, Boolean> getAction() {
		return action;
	}
}
