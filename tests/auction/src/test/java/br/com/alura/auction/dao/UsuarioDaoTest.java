package br.com.alura.auction.dao;

import br.com.alura.auction.model.Usuario;
import br.com.alura.auction.util.builder.UsuarioBuilder;
import util.JPAUtil;
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

    @Test
    void deveriaEncontrarUsuarioCadastrado() {

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criarEPersistir(this.em);

        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());

        assertNotNull(usuarioEncontrado);
    }

    @Test
    void naoDeveriaEncontrarUsuarioNaoCadastrado() {

        new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criarEPersistir(this.em);

        assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("fulano1"));
    }

    @Test
    void deveriaRemoverUmUsuario() {

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criarEPersistir(this.em);

        this.dao.deletar(usuario);

        assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));
    }
}