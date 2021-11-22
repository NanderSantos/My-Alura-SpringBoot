package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;

import java.math.BigDecimal;

public class BudgetCompositionTest {

    public static void main(String[] args) {

        Budget oldBudget = new Budget();
        oldBudget.addItem(new BudgetItem(new BigDecimal("200")));
        oldBudget.reprove();

        Budget newBudget = new Budget();
        newBudget.addItem(new BudgetItem(new BigDecimal("500")));
        newBudget.addItem(oldBudget);

        System.out.println(newBudget.getValue());
    }
}
