package ru.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.base.BasePage;

public class MainPage extends BasePage {

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By personalAccountLink = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private final By mainTitle = By.xpath("//h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainPageLoaded() {
        return isDisplayed(mainTitle);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickPersonalAccountLink() {
        click(personalAccountLink);
    }

    public boolean isOrderButtonDisplayed() {
        return isDisplayed(orderButton);
    }

    public void waitForOrderButtonVisible() {
        waitForElementVisible(orderButton);
    }
}