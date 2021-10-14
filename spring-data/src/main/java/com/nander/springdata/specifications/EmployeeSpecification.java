package com.nander.springdata.specifications;

import java.time.LocalDate;

import com.nander.springdata.orm.Employee;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

	public static Specification<Employee> name(String name) {

		return (root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.like(root.get("name"), "%" + name + "%");
		};
	}

	public static Specification<Employee> cpf(String cpf) {

		return (root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get("cpf"), cpf);
		};
	}

	public static Specification<Employee> salary(Double salary) {

		return (root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.greaterThan(root.get("salary"), salary);
		};
	}

	public static Specification<Employee> hiringDate(LocalDate hiringDate) {

		return (root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.greaterThan(root.get("hiringDate"), hiringDate);
		};
	}
}
