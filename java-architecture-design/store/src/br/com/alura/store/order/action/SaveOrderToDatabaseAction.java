package br.com.alura.store.order.action;

import br.com.alura.store.order.Order;

public class SaveOrderToDatabaseAction implements CreateOrderAction {

    @Override
    public void exec(Order order) {
        System.out.println("Salvando pedidos no banco de dados...");
    }
}
