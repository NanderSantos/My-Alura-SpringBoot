package br.com.alura.store.tests;

import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {

        Product cell = new Product();
        cell.setName("Xiaomi Redmi Note 10s");
        cell.setDescription("Muito Legal!");
        cell.setPrice(new BigDecimal(800));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cell);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(cell.getPrice());
    }
}
