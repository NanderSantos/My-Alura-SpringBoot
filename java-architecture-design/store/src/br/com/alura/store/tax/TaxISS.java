package br.com.alura.store.tax;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class TaxISS extends Tax {

    public TaxISS(Tax next) {
        super(next);
    }

    @Override
    protected BigDecimal execCalc(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.06"));
    }
}
