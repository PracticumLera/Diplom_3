package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.base.BasePage;

public class RegisterPage extends BasePage {

    private final By registerTitle = By.xpath("//h2[text()='Регистрация']");
    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By passwordError = By.xpath("//p[contains(@class, 'input__error')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить загрузку страницы регистрации")
    public boolean isRegisterPageLoaded() {
        return isDisplayed(registerTitle);
    }

    @Step("Ввести имя: {name}")
    public void enterName(String name) {
        type(nameField, name);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    @Step("Нажать кнопку «Зарегистрироваться»")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Нажать ссылку «Войти»")
    public void clickLoginLink() {
        click(loginLink);
    }

    @Step("Зарегистрировать пользователя: {name}")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    @Step("Проверить отображение ошибки пароля")
    public boolean isPasswordErrorDisplayed() {
        return isDisplayed(passwordError);
    }

    @Step("Получить текст ошибки пароля")
    public String getPasswordErrorText() {
        return getText(passwordError);
    }
}