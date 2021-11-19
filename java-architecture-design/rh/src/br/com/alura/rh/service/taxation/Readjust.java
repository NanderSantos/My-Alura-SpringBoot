package br.com.alura.rh.service.taxation;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Readjust {

    BigDecimal value();
    LocalDate date();
}
