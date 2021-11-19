package br.com.alura.store.discount;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class DiscountCalculator {

    public BigDecimal calculate(Budget budget) {

        Discount discountChain = new DiscountBudgetWithMoreThen5Items(
                new DiscountBudgetWithValueGreatherThen500(
                        new DiscountNotApplied()
                )
        );

        return discountChain.calculate(budget);
    }
}
