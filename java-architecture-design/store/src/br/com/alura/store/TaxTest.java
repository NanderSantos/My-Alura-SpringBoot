package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;
import br.com.alura.store.tax.TaxISS;
import br.com.alura.store.tax.TaxCalculator;

import java.math.BigDecimal;

public class TaxTest {

    public static void main(String[] args) {

        Budget budget = new Budget();
        budget.addItem(new BudgetItem(new BigDecimal("1000")));
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println(taxCalculator.calculate(budget, new TaxISS(null)));
    }
}
