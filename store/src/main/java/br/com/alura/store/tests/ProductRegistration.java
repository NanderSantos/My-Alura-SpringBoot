package br.com.alura.store.tests;

import br.com.alura.store.dao.CategoryDao;
import br.com.alura.store.dao.ProductDao;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;
import br.com.alura.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {

    public static void main(String[] args) {

        registerProduct();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);

        Product product = productDao.findById(1L);
        System.out.println(product.getName() + ": R$" + product.getPrice());

        List<Product> productList = productDao.findAll();
        productList.forEach(p -> System.out.println(p.getId() + ": " + p.getName() + ": R$" + p.getPrice()));

        List<Product> productListByName = productDao.findAllByName("Xiaomi Redmi Note 10s");
        productListByName.forEach(p -> System.out.println(p.getId() + ": " + p.getName() + ": R$" + p.getPrice()));

        List<Product> productListByCategory = productDao.findAllByCategoryName("CELL_PHONES");
        productListByCategory.forEach(p -> System.out.println(p.getId() + ": " + p.getName() + ": R$" + p.getPrice()));

        BigDecimal price = productDao.findProductPriceByName("Xiaomi Redmi Note 10s");
        System.out.println("Preço: R$" + price);

        updateCategory();
        deleteProduct();
    }

    private static void registerProduct() {

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

    private static void updateCategory() {

        Category category = new Category("COMPUTING");

        EntityManager entityManager = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();

        categoryDao.save(category);
        entityManager.flush();

        categoryDao.update(category);
        entityManager.flush();

        entityManager.clear();

        category.setName("CELL_PHONES");
        categoryDao.update(category);
        entityManager.flush();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void deleteProduct() {

        Category category = new Category("XPTO");

        Product cell = new Product(
                "Xiaomi Redmi Note 9",
                "Muito Legal!",
                new BigDecimal(800),
                category
        );

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();

        categoryDao.save(category);
        entityManager.flush();

        productDao.save(cell);
        entityManager.flush();

        productDao.delete(cell);
        entityManager.flush();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
