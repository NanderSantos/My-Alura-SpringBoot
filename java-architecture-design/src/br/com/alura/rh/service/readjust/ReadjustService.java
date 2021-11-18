package br.com.alura.rh.service.readjust;

import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public class ReadjustService {

    private List<ReadjustValidation>  validations;

    public ReadjustService(List<ReadjustValidation> validations) {
        this.validations = validations;
    }

    public void readjustEmployeeSalary(Employee employee, BigDecimal salaryIncrease) {

        this.validations.forEach(v -> v.validate(employee, salaryIncrease));
        employee.updateSalary(employee.getSalary().add(salaryIncrease));
    }
}
