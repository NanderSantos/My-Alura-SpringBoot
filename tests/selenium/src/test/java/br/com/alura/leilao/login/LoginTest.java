package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.loginPage.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {

        this.loginPage.preencheFormularioDeLogin("fulano", "pass");
        this.loginPage.submeteFormularioDeLogin("login-form");

        Assertions.assertFalse(this.loginPage.isPaginaDeLogin());
        Assertions.assertEquals("fulano", this.loginPage.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {

        this.loginPage.preencheFormularioDeLogin("invalido", "123123");
        this.loginPage.submeteFormularioDeLogin("login-form");

        Assertions.assertTrue(this.loginPage.isPaginaDeLogin());
        Assertions.assertNull(this.loginPage.getNomeUsuarioLogado());
        Assertions.assertTrue(this.loginPage.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {

        this.loginPage.navegaParaPaginaDeLances();

        Assertions.assertTrue(this.loginPage.isPaginaDeLogin());
        Assertions.assertFalse(this.loginPage.contemTexto("Dados do Leilão"));
    }
}
