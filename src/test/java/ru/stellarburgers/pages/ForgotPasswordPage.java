package ru.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.base.BasePage;

public class ForgotPasswordPage extends BasePage {

    private final By pageTitle = By.xpath("//h2[text()='Восстановление пароля']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isForgotPasswordPageLoaded() {
        return isDisplayed(pageTitle);
    }

    public void clickLoginLink() {
        click(loginLink);
    }
}
