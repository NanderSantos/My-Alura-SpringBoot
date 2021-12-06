package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private final String LOGIN_URL = "http://localhost:8080/login";
    private WebDriver browser;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    }

    @BeforeEach
    public void beforeEach() {
        this.browser = new ChromeDriver();
        this.browser.navigate().to(this.LOGIN_URL);
    }

    @AfterEach
    public void afterEach() {
        this.browser.quit();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {

        String username = "fulano";
        String password = "pass";

        this.browser.findElement(By.ById.id("username")).sendKeys(username);
        this.browser.findElement(By.ById.id("password")).sendKeys(password);
        this.browser.findElement(By.ById.id("login-form")).submit();

        Assertions.assertNotEquals(this.LOGIN_URL, this.browser.getCurrentUrl());
        Assertions.assertEquals(username, this.browser.findElement(By.ById.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {

        String username = "invalido";
        String password = "123123";

        this.browser.findElement(By.ById.id("username")).sendKeys(username);
        this.browser.findElement(By.ById.id("password")).sendKeys(password);
        this.browser.findElement(By.ById.id("login-form")).submit();

        Assertions.assertEquals(this.LOGIN_URL + "?error", this.browser.getCurrentUrl());
        Assertions.assertTrue(this.browser.getPageSource().contains("Usuário e senha inválidos."));
        Assertions.assertThrows(NoSuchElementException.class, () -> this.browser.findElement(By.ById.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {

        this.browser.navigate().to("http://localhost:8080/leiloes/2");
        Assertions.assertEquals(this.LOGIN_URL, this.browser.getCurrentUrl());
        Assertions.assertFalse(this.browser.getPageSource().contains("Dados do Leilão"));
    }
}
