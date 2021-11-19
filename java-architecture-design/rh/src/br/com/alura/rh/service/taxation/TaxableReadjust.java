package br.com.alura.rh.service.taxation;

import java.math.BigDecimal;

public interface TaxableReadjust extends Readjust {

    BigDecimal taxValue();
}
