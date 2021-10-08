package br.com.alura.store.dao;

import br.com.alura.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Product> findByOldOptionalParameters(String name, BigDecimal price, LocalDate creationDate) {

        String jpql = "SELECT p FROM Product p WHERE 1=1";

        boolean isNamePresent = name != null && !name.trim().isEmpty();
        boolean isPricePresent = price != null;
        boolean isCreationDatePresent = creationDate != null;

        jpql += isNamePresent ? " AND p.name = :name" : "";
        jpql += isPricePresent ? " AND p.price = :price" : "";
        jpql += isCreationDatePresent ? " AND p.creationDate = :creationDate" : "";

        TypedQuery<Product> query = this.entityManager.createQuery(jpql, Product.class);

        if (isNamePresent) query.setParameter("name", name);
        if (isPricePresent) query.setParameter("price", price);
        if (isCreationDatePresent) query.setParameter("creationDate", creationDate);

        return query.getResultList();
    }

    public List<Product> findByCriteriaOptionalParameters(String name, BigDecimal price, LocalDate creationDate) {

        boolean isNamePresent = name != null && !name.trim().isEmpty();
        boolean isPricePresent = price != null;
        boolean isCreationDatePresent = creationDate != null;

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        Predicate filters = criteriaBuilder.and();

        if (isNamePresent)
            filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("name"), name));


        if (isPricePresent)
            filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("price"), price));


        if (isCreationDatePresent)
            filters = criteriaBuilder.and(filters, criteriaBuilder.equal(from.get("creationDate"), creationDate));

        query.where(filters);

        return this.entityManager.createQuery(query).getResultList();
    }
}
