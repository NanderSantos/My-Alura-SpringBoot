package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        if (browser == null) {
            browser = new ChromeDriver();
        }

        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }
}
