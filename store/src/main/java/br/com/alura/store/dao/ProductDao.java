package br.com.alura.store.dao;

import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

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

    public Product findById(Long id) {

        return this.entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {

        String jpql = "SELECT p FROM Product p";

        return this.entityManager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findAllByName(String name) {

        String jpql = "SELECT p FROM Product p WHERE p.name = :name";

        return this.entityManager
                .createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> findAllByCategoryName(String name) {

        return this.entityManager
                .createNamedQuery("Product.productsByCategoryName", Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public BigDecimal findProductPriceByName(String name) {

        String jpql = "SELECT p.price FROM Product p WHERE p.name = :name";

        return this.entityManager
                .createQuery(jpql, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
