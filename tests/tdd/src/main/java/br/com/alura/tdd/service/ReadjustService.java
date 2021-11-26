package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Employee;

import java.math.BigDecimal;

public class ReadjustService {

    public void concernReadjust(Employee employee, Performance performance) {

        BigDecimal readjust = employee.getSalary().multiply(performance.readjustPercentual());
        employee.readjustSalary(readjust);
    }
}
