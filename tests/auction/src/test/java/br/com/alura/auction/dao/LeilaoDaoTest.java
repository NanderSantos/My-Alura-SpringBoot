package br.com.alura.auction.dao;

import br.com.alura.auction.model.Leilao;
import br.com.alura.auction.model.Usuario;
import br.com.alura.auction.util.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeilaoDaoTest {

    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        this.em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        this.em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastrarUmLeilao() {

        Leilao leilao = criarLeilao();
        leilao = this.dao.salvar(leilao);

        Leilao leilaoSalvo = this.dao.buscarPorId(leilao.getId());

        assertNotNull(leilaoSalvo);
    }

    @Test
    void deveriaAtualizarUmLeilao() {

        Leilao leilao = criarLeilao();
        leilao = this.dao.salvar(leilao);

        leilao.setNome("Celular");
        leilao.setValorInicial(new BigDecimal("400"));

        leilao = this.dao.salvar(leilao);

        Leilao leilaoSalvo = this.dao.buscarPorId(leilao.getId());

        assertEquals("Celular", leilaoSalvo.getNome());
        assertEquals(new BigDecimal("400"), leilaoSalvo.getValorInicial());
    }

    @Test
    void buscarTodos() {
    }

    @Test
    void buscarLeiloesDoPeriodo() {
    }

    @Test
    void buscarLeiloesDoUsuario() {
    }

    private Leilao criarLeilao() {

        return new Leilao(
                "Mochila",
                new BigDecimal("70"),
                LocalDate.now(),
                criarEPersistirUsuario()
        );
    }

    private Leilao criarEPersistirLeilao() {

        Leilao leilao =  new Leilao(
                "Mochila",
                new BigDecimal("70"),
                LocalDate.now(),
                criarEPersistirUsuario()
        );

        this.em.persist(leilao);

        return leilao;
    }

    private Usuario criarEPersistirUsuario() {

        Usuario usuario =  new Usuario("fulano", "fulano@email.com", "12345678");
        this.em.persist(usuario);

        return usuario;
    }
}