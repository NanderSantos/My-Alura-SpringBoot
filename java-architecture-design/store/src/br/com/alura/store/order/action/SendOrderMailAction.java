package br.com.alura.store.order.action;

import br.com.alura.store.order.Order;

public class SendOrderMailAction implements CreateOrderAction {

    @Override
    public void exec(Order order) {
        System.out.println("Enviando email com dados do novo pedido...");
    }
}
