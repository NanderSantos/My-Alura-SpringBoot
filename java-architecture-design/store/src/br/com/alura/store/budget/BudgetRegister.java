package br.com.alura.store.budget;

import br.com.alura.store.ExceptionDomain;
import br.com.alura.store.http.HttpAdapter;

import java.util.Map;

public class BudgetRegister {

    private HttpAdapter httpAdapter;

    public BudgetRegister(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    public void register(Budget budget) {

        if (!budget.isFinished()) {
            throw new ExceptionDomain("Orçamento não finalizado!");
        }

        String url = "http://api.externa/budget";
        Map<String, Object> objectMap = Map.of(
                "value", budget.getValue(),
                "itemsQuantity", budget.getItemsQuantity()
        );

        this.httpAdapter.post(url, objectMap);
    }
}
