package br.com.alura.store.dao;

import br.com.alura.store.model.Order;
import br.com.alura.store.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDao {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BigDecimal totalValueSold() {

        String jpql = "SELECT SUM(o.totalValue) FROM Order o";

        return this.entityManager
                .createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<SalesReportVo> salesReport() {

        String jpql = "SELECT new br.com.alura.store.vo.SalesReportVo(" +
                "p.name, " +
                "SUM(i.quantity), " +
                "MAX(o.date)) " +
                "FROM Order o " +
                "JOIN o.items i " +
                "JOIN i.product p " +
                "GROUP BY p.name " +
                "ORDER BY i.quantity DESC";

        return this.entityManager
                .createQuery(jpql, SalesReportVo.class)
                .getResultList();
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

    public Order findOrderWithClient(Long id) {

        String jpql = "SELECT o FROM Order o JOIN FETCH o.client WHERE o.id = :id";

        return this.entityManager
                .createQuery(jpql, Order.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
