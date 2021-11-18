package br.com.alura.rh.service.readjust;

import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;

public interface ReadjustValidation {

    void validate(Employee employee, BigDecimal salaryIncrease);
}
