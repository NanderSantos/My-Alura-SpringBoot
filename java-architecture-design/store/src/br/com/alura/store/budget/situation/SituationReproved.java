package br.com.alura.store.budget.situation;

import br.com.alura.store.ExceptionDomain;
import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public class SituationReproved extends Situation {

    @Override
    public void finish(Budget budget) {
        budget.setSituation(new SituationFinished());
    }
}
