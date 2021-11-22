package br.com.alura.store.order.action;

import br.com.alura.store.order.Order;

public class OrderLog implements CreateOrderAction {

    @Override
    public void exec(Order order) {
        System.out.println("Pedido gerado: " + order);
    }
}
