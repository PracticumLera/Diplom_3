package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.base.BasePage;

public class LoginPage extends BasePage {

    private final By loginTitle = By.xpath("//h2[text()='Вход']");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить загрузку страницы входа")
    public boolean isLoginPageLoaded() {
        return isDisplayed(loginTitle);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    @Step("Нажать кнопку «Войти»")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Выполнить вход: {email}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}