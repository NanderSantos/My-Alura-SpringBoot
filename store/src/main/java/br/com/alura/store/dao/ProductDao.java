package br.com.alura.store.dao;

import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {

    private final EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Product product) {

        this.entityManager.persist(product);
    }

    public void update(Product product) {

        this.entityManager.merge(product);
    }

    public void delete(Product product) {

        product = this.entityManager.merge(product);
        this.entityManager.remove(product);
    }
}
