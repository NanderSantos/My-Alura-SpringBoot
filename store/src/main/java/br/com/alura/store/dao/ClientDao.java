package br.com.alura.store.dao;

import br.com.alura.store.model.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {

    private final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Client client) {

        this.entityManager.persist(client);
    }

    public void update(Client client) {

        this.entityManager.merge(client);
    }

    public void delete(Client client) {

        client = this.entityManager.merge(client);
        this.entityManager.remove(client);
    }

    public Client findById(Long id) {

        return this.entityManager.find(Client.class, id);
    }

    public List<Client> findAll() {

        String jpql = "SELECT p FROM Client p";

        return this.entityManager.createQuery(jpql, Client.class).getResultList();
    }
}
