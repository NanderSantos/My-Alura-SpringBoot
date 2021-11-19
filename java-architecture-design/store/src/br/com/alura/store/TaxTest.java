package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.tax.ISS;
import br.com.alura.store.tax.TaxCalculator;

import java.math.BigDecimal;

public class TaxTest {

    public static void main(String[] args) {

        Budget budget = new Budget(new BigDecimal(1000));
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println(taxCalculator.calculate(budget, new ISS()));
    }
}
