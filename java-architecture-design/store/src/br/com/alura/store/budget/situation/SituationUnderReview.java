package br.com.alura.store.budget.situation;

import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class SituationUnderReview extends Situation {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void approve(Budget budget) {
        budget.setSituation(new SituationApproved());
    }

    @Override
    public void reprove(Budget budget) {
        budget.setSituation(new SituationReproved());
    }
}
