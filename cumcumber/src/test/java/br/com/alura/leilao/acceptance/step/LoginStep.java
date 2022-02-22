package br.com.alura.leilao.acceptance.step;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginStep {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("o usuário válido")
    public void oUsuarioValido() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
    }

    @Quando("realiza login")
    public void realizaLogin() {
        this.leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Então("é redirecionado para a página de leilões")
    public void eRedirecionadoParaAPaginaDeLeiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
        this.browser.clean();
    }

    @Dado("o usuário inválido")
    public void oUsuarioInvalido() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
    }

    @Quando("tenta se logar")
    public void tentaSeLogar() {
        this.leiloesPage = this.loginPage.realizaLoginComo("fulano", "xpto");
    }

    @Então("continua na página de login")
    public void continuaNaPaginaDeLogin() {
        Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
        this.browser.clean();
    }
}
