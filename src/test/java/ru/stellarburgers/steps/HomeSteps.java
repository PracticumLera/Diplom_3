package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class HomeSteps {

    private final MainPage mainPage;

    public HomeSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    @Step("Проверить загрузку главной страницы")
    public HomeSteps verifyHomePageLoaded() {
        assertTrue("Главная страница не загрузилась", mainPage.isMainPageLoaded());
        return this;
    }

    @Step("Нажать кнопку «Войти в аккаунт»")
    public HomeSteps clickLoginButton() {
        mainPage.clickLoginButton();
        return this;
    }

    @Step("Нажать кнопку «Личный кабинет»")
    public HomeSteps clickProfileButton() {
        mainPage.clickPersonalAccountLink();
        return this;
    }

    @Step("Проверить, что вход выполнен")
    public HomeSteps verifyLoggedIn() {
        mainPage.waitForOrderButtonVisible();
        assertTrue("Вход не выполнен — кнопка «Оформить заказ» не появилась",
                mainPage.isOrderButtonDisplayed());
        return this;
    }
}
