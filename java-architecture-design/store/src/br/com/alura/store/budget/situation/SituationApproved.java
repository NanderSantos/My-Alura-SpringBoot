package br.com.alura.store.budget.situation;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class SituationApproved extends Situation {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finish(Budget budget) {
        budget.setSituation(new SituationFinished());
    }
}
