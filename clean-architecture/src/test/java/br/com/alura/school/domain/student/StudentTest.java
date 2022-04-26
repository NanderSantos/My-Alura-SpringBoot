package br.com.alura.school.domain.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {

    private Student student;

    @BeforeEach
    void beforeEach() {
        this.student = new Student(
                new CPF("123.456.789-00"),
                "Fulano da Silva",
                new Email("fulano@email.com")
        );
    }

    @Test
    void shouldAllowAddOnePhone() {
        this.student.addPhone("31", "999999999");
        Assertions.assertEquals(1, this.student.getPhones().size());
    }

    @Test
    void shouldAllowAddTwoPhone() {
        this.student.addPhone("31", "999999999");
        this.student.addPhone("31", "88888888");
        Assertions.assertEquals(2, this.student.getPhones().size());
    }

    @Test
    void shouldNotAllowAddThreePhone() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.student.addPhone("31", "999999999");
            this.student.addPhone("31", "88888888");
            this.student.addPhone("31", "777777777");
        });
    }
}
