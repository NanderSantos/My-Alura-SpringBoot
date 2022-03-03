import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    void shouldNotCreatePhoneWithInvalidDDD() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone(null, "12345678"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("", "12345678"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("1", "12345678"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("123", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneWithInvalidNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("12", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("12", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("12", "1234567"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Phone("12", "1234567890"));
    }

    @Test
    void shouldCreatePhonesWithValidDDDAndNumber() {

        Phone phone8Digits = new Phone("31", "12345678");
        Phone phone9Digits = new Phone("31", "123456789");

        Assertions.assertEquals("(31) 1234-5678", phone8Digits.getFormattedNumber());
        Assertions.assertEquals("(31) 1 2345-6789", phone9Digits.getFormattedNumber());
    }
}
