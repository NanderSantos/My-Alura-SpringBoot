package br.com.alura.store.order;

import br.com.alura.store.budget.Budget;

import java.time.LocalDateTime;

public class CreateOrderHandler {

    // Injeção de dependências: OrderRepository, EmailService...

    public CreateOrderHandler(/* Injeção de dependências */) {

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

        System.out.println("Salvando pedidos no banco de dados...");
        System.out.println("Enviando email com dados do novo pedido...");
    }
}
