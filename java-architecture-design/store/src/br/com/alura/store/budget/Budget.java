package br.com.alura.store.budget;

import br.com.alura.store.budget.situation.Situation;

import java.math.BigDecimal;

public class Budget {

    private BigDecimal value;
    private int itemsQuantity;
    private Situation situation;

    public Budget(BigDecimal value, int itemsQuantity) {
        this.value = value;
        this.itemsQuantity = itemsQuantity;
    }

    public void applyExtraDiscount() {

        BigDecimal extraDiscountValue = this.situation.calculateExtraDiscount(this);
        this.value = this.value.subtract(extraDiscountValue);
    }

    public void approve() {
        this.situation.approve(this);
    }

    public void reprove() {
        this.situation.reprove(this);
    }

    public void finish() {
        this.situation.finish(this);
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }
}
