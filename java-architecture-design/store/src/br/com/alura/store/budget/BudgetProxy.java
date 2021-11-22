package br.com.alura.store.budget;

import java.math.BigDecimal;

public class BudgetProxy implements Budgetable {

    private BigDecimal value;
    private Budget budget;

    public BudgetProxy(Budget budget) {
        this.value = value;
        this.budget = budget;
    }

    @Override
    public BigDecimal getValue() {

        if (this.value == null) {
            this.value = this.budget.getValue();
        }

        return this.value;
    }
}
