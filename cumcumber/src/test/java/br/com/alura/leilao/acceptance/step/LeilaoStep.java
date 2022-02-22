package br.com.alura.leilao.acceptance.step;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LeilaoStep {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;

    @Dado("um usuário logado")
    public void umUsuarioLogado() {
        this.browser = new Browser();
        this.browser.seed();
        this.loginPage = browser.getLoginPage();
        this.leiloesPage = this.loginPage.realizaLoginComoFulano();
    }

    @Quando("acessa a página de novo leilão")
    public void acessaAPaginaDeNovoLeilao() {
        this.novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }

    @E("prenche o formulário com dados válidos")
    public void prencheOFormularioComDadosValidos() {
        this.leiloesPage = this.novoLeilaoPage.preencheForm(
                "PC Novo",
                "1500",
                "22/02/2022"
        );
    }

    @Então("volta para a página de leilões")
    public void voltaParaAPaginaDeLeiloes() {
        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }

    @E("o novo leilão aparece na tabela")
    public void oNovoLeilaoApareceNaTabela() {
        Assert.assertTrue(this.leiloesPage.existe(
                "PC Novo",
                "1500",
                "22/02/2022",
                "fulano"
        ));
        this.browser.clean();
    }
}
