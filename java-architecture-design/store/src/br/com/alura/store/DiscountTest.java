package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.discount.DiscountCalculator;

import java.math.BigDecimal;

public class DiscountTest {

    public static void main(String[] args) {

        DiscountCalculator discountCalculator = new DiscountCalculator();

        Budget firstBudget = new Budget(new BigDecimal(1000), 5);
        System.out.println(discountCalculator.calculate(firstBudget));

        Budget secondBudget = new Budget(new BigDecimal(1000), 6);
        System.out.println(discountCalculator.calculate(secondBudget));
    }
}
