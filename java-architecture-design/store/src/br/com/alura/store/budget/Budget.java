package br.com.alura.store.budget;

import br.com.alura.store.budget.situation.Situation;
import br.com.alura.store.budget.situation.SituationFinished;
import br.com.alura.store.budget.situation.SituationUnderReview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Budget implements Budgetable {

    private BigDecimal value;
    private Situation situation;
    private List<Budgetable> items;

    public Budget() {
        this.value = BigDecimal.ZERO;
        this.situation = new SituationUnderReview();
        this.items = new ArrayList<>();
    }

    public void applyExtraDiscount() {

        BigDecimal extraDiscountValue = this.situation.calculateExtraDiscount(this);
        this.value = this.value.subtract(extraDiscountValue);
    }

    public void addItem(Budgetable item) {

        this.value = this.value.add(item.getValue());
        this.items.add(item);
    }

    public boolean isFinished() {
        return this.situation instanceof SituationFinished;
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

    @Override
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getItemsQuantity() {
        return items.size();
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public List<Budgetable> getItems() {
        return items;
    }

    public void setItems(List<Budgetable> items) {
        this.items = items;
    }
}
