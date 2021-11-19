package br.com.alura.store.tax;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class TaxISS implements Tax {

    @Override
    public BigDecimal calculate(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.06"));
    }
}
