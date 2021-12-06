package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private final String LOGIN_URL = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        this.browser = new ChromeDriver();
        this.browser.navigate().to(this.LOGIN_URL);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void preencheFormularioDeLogin(String username, String password) {
        this.browser.findElement(By.ById.id("username")).sendKeys(username);
        this.browser.findElement(By.ById.id("password")).sendKeys(password);
    }


    public void submeteFormularioDeLogin(String form) {
        this.browser.findElement(By.ById.id(form)).submit();
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
