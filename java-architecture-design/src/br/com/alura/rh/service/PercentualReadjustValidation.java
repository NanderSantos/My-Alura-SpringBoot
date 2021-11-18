package br.com.alura.rh.service;

import br.com.alura.rh.ExceptionValidation;
import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentualReadjustValidation implements ReadjustValidation {

    public void validate(Employee employee, BigDecimal salaryIncrease) {

        BigDecimal percentualReadjust = salaryIncrease.divide(
                employee.getSalary(),
                RoundingMode.HALF_UP
        );

        if(percentualReadjust.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ExceptionValidation("Reajuste não pode ser superior a 40% do salário");
        }
    }
}
