package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDao;
import br.com.alura.store.dao.ClientDao;
import br.com.alura.store.dao.OrderDao;
import br.com.alura.store.dao.ProductDao;
import br.com.alura.store.model.*;
import br.com.alura.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrderRegistration {

    public static void main(String[] args) {

        initializeDB();

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        Product product = productDao.findById(1L);

        ClientDao clientDao = new ClientDao(entityManager);
        Client client = clientDao.findById(1L);

        entityManager.getTransaction().begin();

        Order order = new Order(client);
        order.addItem(new OrderItem(10, order, product));
        OrderDao orderDao = new OrderDao(entityManager);
        orderDao.save(order);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void initializeDB() {

        Category category = new Category("CELL_PHONES");

        Product cell = new Product(
                "Xiaomi Redmi Note 10s",
                "Muito Legal!",
                new BigDecimal(800),
                category
        );

        Client client = new Client("Nander", "123456");

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);

        entityManager.getTransaction().begin();

        categoryDao.save(category);
        productDao.save(cell);
        clientDao.save(client);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
