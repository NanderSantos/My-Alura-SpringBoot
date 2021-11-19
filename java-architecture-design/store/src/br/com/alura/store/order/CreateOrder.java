package br.com.alura.store.order;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateOrder {

    private String client;
    private BigDecimal budgetValue;
    private int itemsQuantity;

    public CreateOrder(String client, BigDecimal budgetValue, int itemsQuantity) {
        this.client = client;
        this.budgetValue = budgetValue;
        this.itemsQuantity = itemsQuantity;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getBudgetValue() {
        return budgetValue;
    }

    public void setBudgetValue(BigDecimal budgetValue) {
        this.budgetValue = budgetValue;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }
}
