package br.com.alura.rh.service.taxation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promotion implements TaxableReadjust {

    private BigDecimal value;
    private LocalDate date;

    public Promotion(BigDecimal value) {
        this.value = value;
        this.date = LocalDate.now();
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }

    @Override
    public LocalDate date() {
        return this.date;
    }

    @Override
    public BigDecimal taxValue() {
        return this.value.multiply(new BigDecimal("0.1"));
    }
}
