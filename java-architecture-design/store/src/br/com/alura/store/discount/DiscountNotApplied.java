package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountNotApplied extends Discount {

    public DiscountNotApplied() {
        super(null);
    }

    @Override
    public BigDecimal calculate(Budget budget) {
        return BigDecimal.ZERO;
    }
}
