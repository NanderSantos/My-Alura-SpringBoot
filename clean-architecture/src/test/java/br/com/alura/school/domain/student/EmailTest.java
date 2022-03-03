package br.com.alura.school.domain.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void shouldNotCreateEmailsWithInvalidAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("email.invalid.com"));
    }

    @Test
    void shouldCreateEmailsWithValidAddress() {

        String expectedEmail = "emailinvalid@gmail.com";
        br.com.alura.school.domain.student.Email createdEmail = new br.com.alura.school.domain.student.Email(expectedEmail);

        Assertions.assertEquals(expectedEmail, createdEmail.getAddress());
    }
}
