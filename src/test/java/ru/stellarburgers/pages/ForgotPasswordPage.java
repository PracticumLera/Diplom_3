package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.base.BasePage;

public class ForgotPasswordPage extends BasePage {

    private final By pageTitle = By.xpath("//h2[text()='Восстановление пароля']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить загрузку страницы восстановления пароля")
    public boolean isForgotPasswordPageLoaded() {
        return isDisplayed(pageTitle);
    }

    @Step("Нажать ссылку «Войти»")
    public void clickLoginLink() {
        click(loginLink);
    }
}