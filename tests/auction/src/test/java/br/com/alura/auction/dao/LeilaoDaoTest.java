package br.com.alura.auction.dao;

import br.com.alura.auction.model.Leilao;
import br.com.alura.auction.model.Usuario;
import br.com.alura.auction.util.builder.UsuarioBuilder;
import util.JPAUtil;
import util.builder.LeilaoBuilder;
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

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criarEPersistir(this.em);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        leilao = this.dao.salvar(leilao);

        Leilao leilaoSalvo = this.dao.buscarPorId(leilao.getId());

        assertNotNull(leilaoSalvo);
    }

    @Test
    void deveriaAtualizarUmLeilao() {

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criarEPersistir(this.em);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criarEPersistir(this.em);

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
}