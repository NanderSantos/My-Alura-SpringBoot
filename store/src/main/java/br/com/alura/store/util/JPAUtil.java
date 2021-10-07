package br.com.alura.store.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");

    public static EntityManager getEntityManager() {

        return factory.createEntityManager();
    }
}
