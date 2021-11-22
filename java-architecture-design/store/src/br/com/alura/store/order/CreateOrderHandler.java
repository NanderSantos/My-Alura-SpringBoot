package br.com.alura.store.order;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.budget.BudgetItem;
import br.com.alura.store.order.action.CreateOrderAction;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CreateOrderHandler {

    private List<CreateOrderAction> actions;

    public CreateOrderHandler(CreateOrderAction... actions) {
        this.actions = Arrays.asList(actions);
    }

    public void exec(CreateOrder createOrderData) {

        Budget budget = new Budget();
        budget.addItem(new BudgetItem(createOrderData.getBudgetValue()));

        Order order = new Order(
                createOrderData.getClient(),
                LocalDateTime.now(),
                budget
        );

        actions.forEach(a -> a.exec(order));
    }
}
