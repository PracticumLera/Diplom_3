package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("Проверить, что мы на странице входа")
    public LoginSteps verifyOnLoginPage() {
        assertTrue("Страница входа не загрузилась", loginPage.isLoginPageLoaded());
        return this;
    }

    @Step("Выполнить вход: {email}")
    public LoginSteps login(String email, String password) {
        loginPage.login(email, password);
        return this;
    }
}
