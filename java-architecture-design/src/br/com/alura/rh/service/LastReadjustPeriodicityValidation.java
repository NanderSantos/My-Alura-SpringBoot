package br.com.alura.rh.service;

import br.com.alura.rh.ExceptionValidation;
import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LastReadjustPeriodicityValidation implements ReadjustValidation {

    public void validate(Employee employee, BigDecimal salaryIncrease) {

        LocalDate lastReadjustDate = employee.getLastReadjustmentDate();
        LocalDate actualDate = LocalDate.now();
        long monthsSinceLastSalaryReadjust = ChronoUnit.MONTHS.between(actualDate, lastReadjustDate);

        if(monthsSinceLastSalaryReadjust < 6) {
            throw new ExceptionValidation("Intervalo de reajuste deve se de no mínimo 6 meses");
        }
    }
}
