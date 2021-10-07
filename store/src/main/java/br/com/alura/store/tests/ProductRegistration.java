package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDao;
import br.com.alura.store.dao.ProductDao;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;
import br.com.alura.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {

    public static void main(String[] args) {

        Category category = new Category("CELL_PHONES");

        Product cell = new Product(
                "Xiaomi Redmi Note 10s",
                "Muito Legal!",
                new BigDecimal(800),
                category
        );

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();
        categoryDao.save(category);
        productDao.save(cell);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
