package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountNotApplied extends Discount {

    public DiscountNotApplied() {
        super(null);
    }

    @Override
    protected BigDecimal apply(Budget budget) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean mustApply(Budget budget) {
        return true;
    }
}
