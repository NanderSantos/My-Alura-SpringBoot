package com.nander.springdata.action;

import java.util.Scanner;
import java.util.function.BiFunction;

import com.nander.springdata.repository.EmployeeRepository;

public class ReportAction {
	
	private int id;
	private String name;
	private BiFunction<Scanner, EmployeeRepository, Boolean> action;

	public ReportAction(int id, String name, BiFunction<Scanner, EmployeeRepository, Boolean> action) {

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

	public BiFunction<Scanner, EmployeeRepository, Boolean> getAction() {
		return action;
	}
}
