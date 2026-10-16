package ru.stellarburgers.pages;

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

    public boolean isRegisterPageLoaded() {
        return isDisplayed(registerTitle);
    }

    public void enterName(String name) {
        type(nameField, name);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    public boolean isPasswordErrorDisplayed() {
        return isDisplayed(passwordError);
    }

    public String getPasswordErrorText() {
        return getText(passwordError);
    }
}