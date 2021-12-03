package br.com.alura.auction.dao;

import br.com.alura.auction.model.Usuario;
import br.com.alura.auction.util.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void buscarPorUsername() {

        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(usuarioEncontrado);
    }

    @Test
    void deletar() {
    }
}