package br.com.alura.store.budget.situation;

import br.com.alura.store.ExceptionDomain;
import br.com.alura.store.budget.Budget;

import java.math.BigDecimal;

public abstract class Situation {

    public BigDecimal calculateExtraDiscount(Budget budget) {
        return BigDecimal.ZERO;
    }

    public void approve(Budget budget) {
        throw new ExceptionDomain("Orçamento não pode ser aprovado!");
    }

    public void reprove(Budget budget) {
        throw new ExceptionDomain("Orçamento não pode ser reprovado!");
    }

    public void finish(Budget budget) {
        throw new ExceptionDomain("Orçamento não pode ser finalizado!");
    }
}
