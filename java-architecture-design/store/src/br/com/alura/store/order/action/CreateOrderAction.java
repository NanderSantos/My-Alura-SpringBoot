package br.com.alura.store.order.action;

import br.com.alura.store.order.Order;

public interface CreateOrderAction {

    void exec(Order order);
}
