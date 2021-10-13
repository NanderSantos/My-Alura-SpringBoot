package com.nander.springdata.action;

import java.util.Scanner;

import com.nander.springdata.repository.EmployeeRepository;
import com.nander.springdata.repository.PositionRepository;
import com.nander.springdata.repository.WorkUnitRepository;

public class EmployeeAction {
	
	private int id;
	private String name;
	private IEmployeeAction<Scanner, EmployeeRepository, PositionRepository, WorkUnitRepository, Boolean> action;

	public EmployeeAction(int id, String name, IEmployeeAction<Scanner, EmployeeRepository, PositionRepository, WorkUnitRepository, Boolean> action) {

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

	public IEmployeeAction<Scanner, EmployeeRepository, PositionRepository, WorkUnitRepository, Boolean> getAction() {
		return action;
	}
}
