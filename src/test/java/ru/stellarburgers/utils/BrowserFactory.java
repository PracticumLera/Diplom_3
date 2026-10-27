package ru.stellarburgers.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.stellarburgers.constants.Config;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver createDriver(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            browserName = Config.DEFAULT_BROWSER;
        }

        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "yandex":
                System.setProperty("webdriver.chrome.driver", Config.YANDEX_DRIVER_PATH);
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(yandexOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.PAGE_LOAD_TIMEOUT));

        return driver;
    }
}