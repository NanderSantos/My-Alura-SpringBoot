package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leilao.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private final static String LOGIN_URL = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        this.browser.navigate().to(LoginPage.LOGIN_URL);
    }

    public void preencheFormularioDeLogin(String username, String password) {
        this.browser.findElement(By.ById.id("username")).sendKeys(username);
        this.browser.findElement(By.ById.id("password")).sendKeys(password);
    }


    public void submeteFormularioDeLogin(String form) {
        this.browser.findElement(By.ById.id(form)).submit();
    }

    public LeiloesPage efetuaLogin() {
        this.browser.findElement(By.ById.id("login-form")).submit();
        return new LeiloesPage(this.browser);
    }

    public boolean isPaginaDeLogin() {
        return this.browser.getCurrentUrl().contains(this.LOGIN_URL);
    }

    public String getNomeUsuarioLogado() {

        try {

            return this.browser.findElement(By.ById.id("usuario-logado")).getText();

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String text) {
        return this.browser.getPageSource().contains(text);
    }
}
