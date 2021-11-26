package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReadjustServiceTest {

    @Test
    public void readjustShouldBeThreePercentWhenPerformanceIsUnsatisfactory() {

        ReadjustService readjustService = new ReadjustService();
        Employee employee = new Employee(
                "Ana",
                LocalDate.now(),
                new BigDecimal("1000")
        );

        readjustService.concernReadjust(employee, Performance.UNSATISFACTORY);

        assertEquals(new BigDecimal("1030.00"), employee.getSalary());
    }

    @Test
    public void readjustShouldBeFifteenPercentWhenPerformanceIsOK() {

        ReadjustService readjustService = new ReadjustService();
        Employee employee = new Employee(
                "Ana",
                LocalDate.now(),
                new BigDecimal("1000")
        );

        readjustService.concernReadjust(employee, Performance.OK);

        assertEquals(new BigDecimal("1150.00"), employee.getSalary());
    }

    @Test
    public void readjustShouldBeTwentyPercentWhenPerformanceIsExcellent() {

        ReadjustService readjustService = new ReadjustService();
        Employee employee = new Employee(
                "Ana",
                LocalDate.now(),
                new BigDecimal("1000")
        );

        readjustService.concernReadjust(employee, Performance.EXCELLENT);

        assertEquals(new BigDecimal("1200.00"), employee.getSalary());
    }
}