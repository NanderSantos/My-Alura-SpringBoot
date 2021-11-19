package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountBudgetWithMoreThen5Items extends Discount {

    public DiscountBudgetWithMoreThen5Items(Discount next) {
        super(next);
    }

    public BigDecimal calculate(Budget budget) {

        if (budget.getItemsQuantity() > 5) {
            return budget.getValue().multiply(new BigDecimal("0.10"));
        }

        return next.calculate(budget);
    }
}
