package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDao;
import br.com.alura.store.dao.ClientDao;
import br.com.alura.store.dao.OrderDao;
import br.com.alura.store.dao.ProductDao;
import br.com.alura.store.model.*;
import br.com.alura.store.util.JPAUtil;
import br.com.alura.store.vo.SalesReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class QueriesPerformance {

    public static void main(String[] args) {

        initializeDB();

        EntityManager entityManager = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(entityManager);
        Order order = orderDao.findOrderWithClient(1L);

        entityManager.close();

        System.out.println("Cliente: " + order.getClient().getName());
    }

    private static void initializeDB() {

        Category categoryCellPhones = new Category("CELL_PHONES");
        Category categoryVideogames = new Category("VIDEOGAMES");
        Category categoryComputing = new Category("COMPUTING");

        Product product1 = new Product(
                "Xiaomi Redmi Note 10s",
                "Muito Legal!",
                new BigDecimal(800),
                categoryCellPhones
        );

        Product product2 = new Product(
                "Xiaomi Redmi Note 9",
                "Muito Legal!",
                new BigDecimal(700),
                categoryCellPhones
        );

        Product product3 = new Product(
                "PS5",
                "Playstation 5 Semi-novo",
                new BigDecimal(4500),
                categoryVideogames
        );

        Product product4 = new Product(
                "Macbook",
                "Macbook Pro Retina, Tela de 13 Polegadas",
                new BigDecimal(13000),
                categoryComputing
        );

        Client client1 = new Client("Nander", "123456");
        Client client2 = new Client("Fernando", "234567");
        Client client3 = new Client("Noé", "345678");

        Order order1 = new Order(client1);
        Order order2 = new Order(client2);
        Order order3 = new Order(client3);

        order1.addItem(new OrderItem(10, order1, product1));
        order1.addItem(new OrderItem(15, order1, product2));
        order2.addItem(new OrderItem(1, order2, product3));
        order3.addItem(new OrderItem(2, order3, product4));

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);
        OrderDao orderDao = new OrderDao(entityManager);

        entityManager.getTransaction().begin();

        categoryDao.save(categoryCellPhones);
        categoryDao.save(categoryVideogames);
        categoryDao.save(categoryComputing);

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);

        clientDao.save(client1);
        clientDao.save(client2);
        clientDao.save(client3);

        orderDao.save(order1);
        orderDao.save(order2);
        orderDao.save(order3);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
