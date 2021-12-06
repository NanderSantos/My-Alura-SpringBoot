package br.com.alura.leilao.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeilaoTest {

    private LeiloesPage leiloesPage;
    private CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    public void beforeEach() {

        LoginPage loginPage = new LoginPage();
        loginPage.preencheFormularioDeLogin("fulano", "pass");

        this.leiloesPage = loginPage.efetuaLogin();
        this.cadastroLeilaoPage = this.leiloesPage.carregarFormulario();
    }

    @AfterEach
    public void afterEach() {
        this.leiloesPage.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        this.leiloesPage = this.cadastroLeilaoPage.cadastrarLeilao(nome, valor, hoje);

        Assertions.assertTrue(this.leiloesPage.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() {

        this.leiloesPage = this.cadastroLeilaoPage.cadastrarLeilao("", "", "");

        Assertions.assertFalse(this.cadastroLeilaoPage.isPaginaAtual());
        Assertions.assertTrue(this.leiloesPage.isPaginaAtual());
        Assertions.assertTrue(this.cadastroLeilaoPage.isMensagensDeValidacaoVisiveis());
    }
}
