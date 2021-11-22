package br.com.alura.store;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;
import br.com.alura.store.discount.DiscountCalculator;

import java.math.BigDecimal;

public class DiscountTest {

    public static void main(String[] args) {

        DiscountCalculator discountCalculator = new DiscountCalculator();

        Budget firstBudget = new Budget();
        firstBudget.addItem(new BudgetItem(new BigDecimal("200")));
        System.out.println(discountCalculator.calculate(firstBudget));

        Budget secondBudget = new Budget();
        secondBudget.addItem(new BudgetItem(new BigDecimal("1000")));
        System.out.println(discountCalculator.calculate(secondBudget));

        Budget thirdBudget = new Budget();
        thirdBudget.addItem(new BudgetItem(new BigDecimal("500")));
        System.out.println(discountCalculator.calculate(thirdBudget));
    }
}
