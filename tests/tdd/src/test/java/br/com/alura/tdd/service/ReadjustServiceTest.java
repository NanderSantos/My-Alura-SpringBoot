package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Employee;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReadjustServiceTest {

    private ReadjustService readjustService;
    private  Employee employee;

    @BeforeAll
    static void initAll() {

        System.out.println("Testes " + ReadjustService.class.getSimpleName() + " inicializados!");
    }

    @BeforeEach
    public void init() {

        System.out.println("Teste inicializado!");

        this.readjustService = new ReadjustService();
        this.employee = new Employee(
                "Ana",
                LocalDate.now(),
                new BigDecimal("1000")
        );
    }

    @AfterEach
    public void finish() {

        System.out.println("Teste realizado!");
    }

    @AfterAll
    static void finishAll() {

        System.out.println("Testes " + ReadjustService.class.getSimpleName() + " finalizados!");
    }

    @Test
    public void readjustShouldBeThreePercentWhenPerformanceIsUnsatisfactory() {

        this.readjustService.concernReadjust(this.employee, Performance.UNSATISFACTORY);
        assertEquals(new BigDecimal("1030.00"), this.employee.getSalary());
    }

    @Test
    public void readjustShouldBeFifteenPercentWhenPerformanceIsOK() {

        this.readjustService.concernReadjust(this.employee, Performance.OK);
        assertEquals(new BigDecimal("1150.00"), this.employee.getSalary());
    }

    @Test
    public void readjustShouldBeTwentyPercentWhenPerformanceIsExcellent() {

        this.readjustService.concernReadjust(this.employee, Performance.EXCELLENT);
        assertEquals(new BigDecimal("1200.00"), this.employee.getSalary());
    }
}