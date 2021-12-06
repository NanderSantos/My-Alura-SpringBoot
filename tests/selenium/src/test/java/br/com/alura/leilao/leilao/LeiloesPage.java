package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {

    private static final String CADASTRO_LEILAO_URL = "http://localhost:8080/leiloes/new";
    private static final String LEILOES_URL = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage carregarFormulario() {

        this.browser.navigate().to(LeiloesPage.CADASTRO_LEILAO_URL);
        return new CadastroLeilaoPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {

        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) &&
                colunaDataAbertura.getText().equals(hoje) &&
                colunaValorInicial.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return this.browser.getCurrentUrl().equals(LeiloesPage.LEILOES_URL);
    }
}
