package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountBudgetWithValueGreatherThen500 extends Discount {

    public DiscountBudgetWithValueGreatherThen500(Discount next) {
        super(next);
    }

    @Override
    protected BigDecimal apply(Budget budget) {
         return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean mustApply(Budget budget) {
        return budget.getValue().compareTo(new BigDecimal("500")) > 0;
    }
}
