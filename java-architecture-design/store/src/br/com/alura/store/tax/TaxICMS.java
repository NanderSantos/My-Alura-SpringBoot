package br.com.alura.store.tax;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class TaxICMS extends Tax {

    public TaxICMS(Tax next) {
        super(next);
    }

    @Override
    public BigDecimal execCalc(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }
}
