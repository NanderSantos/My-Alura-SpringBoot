package br.com.alura.store.order;

import br.com.alura.store.budget.Budget;
import br.com.alura.store.order.action.CreateOrderAction;

import java.time.LocalDateTime;
import java.util.List;

public class CreateOrderHandler {

    private List<CreateOrderAction> actions;

    public CreateOrderHandler(List<CreateOrderAction> actions) {
        this.actions = actions;
    }

    public void exec(CreateOrder createOrderData) {

        Order order = new Order(
                createOrderData.getClient(),
                LocalDateTime.now(),
                new Budget(
                        createOrderData.getBudgetValue(),
                        createOrderData.getItemsQuantity()
                )
        );

        actions.forEach(a -> a.exec(order));
    }
}
