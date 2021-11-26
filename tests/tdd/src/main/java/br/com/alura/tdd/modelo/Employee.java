package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {

	private String name;
	private LocalDate admissionDate;
	private BigDecimal salary;

	public Employee(String name, LocalDate admissionDate, BigDecimal salary) {
		this.name = name;
		this.admissionDate = admissionDate;
		this.salary = salary;
		this.setSalaryScale();
	}

	public void readjustSalary(BigDecimal readjust) {
		this.salary = this.salary.add(readjust);
		this.setSalaryScale();
	}

	private void setSalaryScale() {
		// Métodos privados não precisam ser testados, eles serão testados indiretamente nos testes dos métodos públicos
		this.salary = this.salary.setScale(2, RoundingMode.HALF_UP);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
		this.setSalaryScale();
	}
}
