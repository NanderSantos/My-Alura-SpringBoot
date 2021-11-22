package br.com.alura.store.tax;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public abstract class Tax {

    private Tax nextTax;

    public Tax(Tax next) {
        this.nextTax = next;
    }

    protected abstract BigDecimal execCalc(Budget budget);

    public BigDecimal calculate(Budget budget) {

        BigDecimal taxValue = this.execCalc(budget);
        BigDecimal nextTextValue = BigDecimal.ZERO;

        if (nextTax != null) {

            nextTextValue = nextTax.execCalc(budget);
        }

        return taxValue.add(nextTextValue);
    }
}
