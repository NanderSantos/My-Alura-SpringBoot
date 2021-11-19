package br.com.alura.store;

import br.com.alura.store.order.CreateOrder;
import br.com.alura.store.order.CreateOrderHandler;

import java.math.BigDecimal;

public class OrderTest {

    public static void main(String[] args) {

        String client = args[0];
        BigDecimal budgetValue = new BigDecimal(args[1]);
        int itemsQuantity = Integer.parseInt(args[2]);

        CreateOrder orderCreated = new CreateOrder(
                client,
                budgetValue,
                itemsQuantity
        );

        CreateOrderHandler createOrderHandler = new CreateOrderHandler(/* dependências */);
        createOrderHandler.exec(orderCreated);
    }
}
