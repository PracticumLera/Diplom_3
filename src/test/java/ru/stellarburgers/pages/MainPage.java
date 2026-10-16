package ru.stellarburgers.pages;

import io.qameta.allure.Step;
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

    @Step("Проверить загрузку главной страницы")
    public boolean isMainPageLoaded() {
        return isDisplayed(mainTitle);
    }

    @Step("Нажать кнопку «Войти в аккаунт»")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Нажать ссылку «Личный Кабинет»")
    public void clickPersonalAccountLink() {
        click(personalAccountLink);
    }

    @Step("Проверить, что кнопка «Оформить заказ» отображается")
    public boolean isOrderButtonDisplayed() {
        return isDisplayed(orderButton);
    }

    @Step("Ожидать появления кнопки «Оформить заказ»")
    public void waitForOrderButtonVisible() {
        waitForElementVisible(orderButton);
    }
}