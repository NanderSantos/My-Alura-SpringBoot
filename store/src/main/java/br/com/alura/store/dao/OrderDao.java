package br.com.alura.store.dao;

import br.com.alura.store.model.Order;
import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDao {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Order order) {

        this.entityManager.persist(order);
    }

    public void update(Order order) {

        this.entityManager.merge(order);
    }

    public void delete(Order order) {

        order = this.entityManager.merge(order);
        this.entityManager.remove(order);
    }

    public Order findById(Long id) {

        return this.entityManager.find(Order.class, id);
    }

    public List<Order> findAll() {

        String jpql = "SELECT p FROM Order p";

        return this.entityManager.createQuery(jpql, Order.class).getResultList();
    }
}
