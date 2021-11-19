package br.com.alura.rh.service.taxation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Annual implements Readjust {

    private BigDecimal value;
    private LocalDate date;

    public Annual(BigDecimal value) {
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
}
