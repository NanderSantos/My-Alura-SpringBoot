package br.com.alura.auction.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("tests");

    public static EntityManager getEntityManager() {
        return JPAUtil.factory.createEntityManager();
    }
}
