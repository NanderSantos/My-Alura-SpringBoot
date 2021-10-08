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

public class OrderRegistration {

    public static void main(String[] args) {

        initializeDB();

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        Product product1 = productDao.findById(1L);
        Product product2 = productDao.findById(2L);
        Product product3 = productDao.findById(3L);
        Product product4 = productDao.findById(4L);

        ClientDao clientDao = new ClientDao(entityManager);
        Client client1 = clientDao.findById(1L);
        Client client2 = clientDao.findById(2L);
        Client client3 = clientDao.findById(3L);

        entityManager.getTransaction().begin();

        Order order1 = new Order(client1);
        order1.addItem(new OrderItem(10, order1, product1));
        order1.addItem(new OrderItem(15, order1, product2));

        Order order2 = new Order(client2);
        order2.addItem(new OrderItem(1, order2, product3));

        Order order3 = new Order(client3);
        order3.addItem(new OrderItem(2, order3, product4));

        OrderDao orderDao = new OrderDao(entityManager);
        orderDao.save(order1);
        orderDao.save(order2);
        orderDao.save(order3);

        entityManager.getTransaction().commit();

        BigDecimal totalValueSold = orderDao.totalValueSold();
        System.out.println("Valor total: R$" + totalValueSold);

        List<SalesReportVo> salesReport = orderDao.salesReport();
        salesReport.forEach(System.out::println);

        entityManager.close();
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

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);

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

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
