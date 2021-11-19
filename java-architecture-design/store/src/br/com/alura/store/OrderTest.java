package br.com.alura.store;

import br.com.alura.store.order.CreateOrder;
import br.com.alura.store.order.CreateOrderHandler;
import br.com.alura.store.order.action.SaveOrderToDatabaseAction;
import br.com.alura.store.order.action.SendOrderMailAction;

import java.math.BigDecimal;
import java.util.Arrays;

public class OrderTest {

    public static void main(String[] args) {

        String client = "João da Silva";
        BigDecimal budgetValue = new BigDecimal("1000");
        int itemsQuantity = Integer.parseInt("2");

        CreateOrder orderCreated = new CreateOrder(
                client,
                budgetValue,
                itemsQuantity
        );

        CreateOrderHandler createOrderHandler = new CreateOrderHandler(
                Arrays.asList(
                        new SaveOrderToDatabaseAction(),
                        new SendOrderMailAction()
                )
        );

        createOrderHandler.exec(orderCreated);
    }
}
