package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;
import br.com.alura.store.budget.BudgetRegister;
import br.com.alura.store.http.JavaHttpClient;

import java.math.BigDecimal;

public class HttpAdapterTest {

    public static void main(String[] args) {

        Budget budget = new Budget();
        budget.addItem(new BudgetItem(BigDecimal.TEN));
        budget.approve();
        budget.finish();

        BudgetRegister register = new BudgetRegister(new JavaHttpClient());
        register.register(budget);
    }
}
