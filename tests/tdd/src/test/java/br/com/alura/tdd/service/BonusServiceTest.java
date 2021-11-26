package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusShouldBe10PerCentOfTheSalary() {

        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calculate(new Employee(
                "Nander",
                LocalDate.now(),
                new BigDecimal("1000")
        ));

        assertEquals(new BigDecimal("100.00"), bonus);
    }

    @Test
    void bonusShouldBe10PerCentForASalaryOf10000() {

        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calculate(new Employee(
                "Nander",
                LocalDate.now(),
                new BigDecimal("10000")
        ));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

    @Test
    void shouldThrowAHighSalaryException() {

        BonusService bonusService = new BonusService();

        assertThrows(
                IllegalArgumentException.class,
                () -> bonusService.calculate(
                        new Employee("Nander", LocalDate.now(), new BigDecimal("25000"))
                )
        );
    }
}