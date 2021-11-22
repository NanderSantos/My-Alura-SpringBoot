package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.tax.TaxCalculator;
import br.com.alura.store.tax.TaxICMS;
import br.com.alura.store.tax.TaxISS;

import java.math.BigDecimal;

public class MultiTaxTest {

    public static void main(String[] args) {

        Budget budget = new Budget(new BigDecimal("100"), 1);
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println(taxCalculator.calculate(budget, new TaxICMS(new TaxISS(null))));
    }
}
