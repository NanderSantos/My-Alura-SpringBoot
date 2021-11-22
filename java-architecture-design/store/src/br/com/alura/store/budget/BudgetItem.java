package br.com.alura.store.budget;

import java.math.BigDecimal;

public class BudgetItem implements Budgetable {

    private BigDecimal value;

    public BudgetItem(BigDecimal value) {
        this.value = value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }
}
