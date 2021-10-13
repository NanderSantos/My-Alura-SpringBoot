package com.nander.springdata.orm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "position_id", nullable = false)
	private Position position;


	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(
		name = "employees_units",
		joinColumns = { @JoinColumn(name = "fk_employee") },
		inverseJoinColumns = { @JoinColumn(name = "fk_work_unit") }
	)
	private List<WorkUnit> workUnits = new ArrayList<>();

	private String name;

	private String cpf;

	private Double salary;

	private LocalDate hiringDate;

	@Override
	public String toString() {

		return "{ id: " + this.id + ", description: \"" + this.name + "\", address: \"" + this.cpf + "\", salary: \"" + this.salary + "\", hiringDate: \"" + this.hiringDate + "\", position: " + this.position.toString() + ", workUnit: " + this.workUnits.toString() + " }";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String description) {
		this.name = description;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String address) {
		this.cpf = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
		position.addEmployee(this);
	}

	public List<WorkUnit> getWorkUnits() {
		return workUnits;
	}

	public void setWorkUnits(List<WorkUnit> workUnits) {
		
		workUnits.forEach(workUnit -> workUnit.addEmployee(this));
		this.workUnits = workUnits;
	}
}