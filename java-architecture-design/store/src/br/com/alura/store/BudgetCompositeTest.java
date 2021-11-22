package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;
import br.com.alura.store.budget.BudgetProxy;

import java.math.BigDecimal;

public class BudgetCompositeTest {

    public static void main(String[] args) {

        Budget oldBudget = new Budget();
        oldBudget.addItem(new BudgetItem(new BigDecimal("200")));
        oldBudget.reprove();

        Budget newBudget = new Budget();
        newBudget.addItem(new BudgetItem(new BigDecimal("500")));
        newBudget.addItem(oldBudget);

        BudgetProxy newBudgetProxy = new BudgetProxy(newBudget);

        System.out.println(newBudgetProxy.getValue());
        System.out.println(newBudgetProxy.getValue());
    }
}
