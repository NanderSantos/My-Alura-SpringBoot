package com.nander.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import com.nander.springdata.orm.Employee;
import com.nander.springdata.projections.EmployeeProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	
	public List<Employee> findByName(String name);

	public Page<Employee> findByNameLike(String string, Pageable pageable);

	@Query("SELECT e FROM Employee e WHERE e.name = :name AND e.salary >= :salary AND e.hiringDate = :hiringDate")
	public List<Employee> findByNameHiringDateSalaryGreather(String name, Double salary, LocalDate hiringDate);

	@Query(value = "SELECT * FROM employees e WHERE e.hiring_date >= :hiringDate", nativeQuery = true)
	public List<Employee> findByHiringDateGrather(LocalDate hiringDate);

	@Query(value = "SELECT id, name, salary FROM employees", nativeQuery = true)
	public Page<EmployeeProjection> getEmployeesSalary(Pageable pageable);
}
