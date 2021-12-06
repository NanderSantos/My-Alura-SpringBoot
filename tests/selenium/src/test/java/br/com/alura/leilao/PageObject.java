package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        if (browser == null) {
            browser = new ChromeDriver();
        }

        this.browser = browser;
        this.browser.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        this.browser.quit();
    }
}
