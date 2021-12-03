package br.com.alura.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldAddTwoPositiveNumbers() {

        Calculator calculator = new Calculator();
        int added = calculator.add(3, 7);

        Assertions.assertEquals(10, added);
    }
}
