package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pages.ForgotPasswordPage;

import static org.junit.Assert.assertTrue;

public class ForgotPasswordSteps {

    private final ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordSteps(WebDriver driver) {
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Step("Проверить, что мы на странице восстановления пароля")
    public ForgotPasswordSteps verifyOnForgotPasswordPage() {
        assertTrue("Страница восстановления не загрузилась",
                forgotPasswordPage.isForgotPasswordPageLoaded());
        return this;
    }

    @Step("Кликнуть на ссылку «Войти»")
    public ForgotPasswordSteps clickLoginLink() {
        forgotPasswordPage.clickLoginLink();
        return this;
    }
}