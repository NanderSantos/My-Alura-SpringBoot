import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CPFTest {

    @Test
    void shouldNotCreateInvalidCPF() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("Not a number"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("11122233344"));
    }

    @Test
    void shouldCreateValidCPF() {
        CPF cpf = new CPF("111.222.333-44");
        Assertions.assertEquals("111.222.333-44", cpf.getNumber());
    }
}
