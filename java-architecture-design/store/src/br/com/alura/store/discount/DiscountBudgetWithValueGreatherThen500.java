package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountBudgetWithValueGreatherThen500 extends Discount {

    public DiscountBudgetWithValueGreatherThen500(Discount next) {
        super(next);
    }

    public BigDecimal calculate(Budget budget) {

        if (budget.getValue().compareTo(new BigDecimal("500")) > 0) {
            return budget.getValue().multiply(new BigDecimal("0.05"));
        }

        return next.calculate(budget);
    }
}
