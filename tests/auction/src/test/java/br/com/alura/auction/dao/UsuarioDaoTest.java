package br.com.alura.auction.dao;

import br.com.alura.auction.model.Usuario;
import br.com.alura.auction.util.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {

    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        this.em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        this.em.getTransaction().rollback();
    }

    private Usuario criarUsuario() {

        Usuario usuario =  new Usuario("fulano", "fulano@email.com", "12345678");
        this.em.persist(usuario);

        return usuario;
    }

    @Test
    void deveriaEncontrarUsuarioCadastrado() {

        Usuario usuario = criarUsuario();
        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());

        assertNotNull(usuarioEncontrado);
    }

    @Test
    void naoDeveriaEncontrarUsuarioNaoCadastrado() {

        criarUsuario();

        assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("fulano1"));
    }

    @Test
    void deletar() {
    }
}