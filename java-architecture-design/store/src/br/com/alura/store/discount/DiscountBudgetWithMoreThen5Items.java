package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountBudgetWithMoreThen5Items extends Discount {

    public DiscountBudgetWithMoreThen5Items(Discount next) {
        super(next);
    }

    @Override
    protected BigDecimal apply(Budget budget) {
         return budget.getValue().multiply(new BigDecimal("0.10"));
    }

    @Override
    public boolean mustApply(Budget budget) {
        return budget.getItemsQuantity() > 5;
    }
}
