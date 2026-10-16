package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pages.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterSteps {

    private final RegisterPage registerPage;

    public RegisterSteps(WebDriver driver) {
        this.registerPage = new RegisterPage(driver);
    }

    @Step("Проверить, что мы на странице регистрации")
    public RegisterSteps verifyRegisterPageLoaded() {
        assertTrue("Страница регистрации не загрузилась", registerPage.isRegisterPageLoaded());
        return this;
    }

    @Step("Кликнуть на ссылку «Войти»")
    public RegisterSteps clickLoginLink() {
        registerPage.clickLoginLink();
        return this;
    }

    @Step("Зарегистрировать пользователя: {name}")
    public RegisterSteps registerUser(String name, String email, String password) {
        registerPage.register(name, email, password);
        return this;
    }

    @Step("Проверить, что ошибка пароля отображается")
    public RegisterSteps verifyPasswordErrorDisplayed() {
        assertTrue("Ошибка пароля не отображается", registerPage.isPasswordErrorDisplayed());
        return this;
    }

    @Step("Проверить текст ошибки пароля")
    public RegisterSteps verifyPasswordErrorText() {
        assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
        return this;
    }
}