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

        /*String expectedEmail = "emailinvalid@gmail.com";
        Email createdEmail = new Email(expectedEmail);

        Assertions.assertEquals(expectedEmail, createdEmail.getAddress());*/
    }
}
