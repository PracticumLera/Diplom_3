package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stellarburgers.base.BasePage;
import ru.stellarburgers.constants.Config;

import java.time.Duration;

public class ConstructorPage extends BasePage {

    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");
    private final By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать вкладку «Булки»")
    public void clickBunsTab() {
        click(bunsTab);
    }

    @Step("Нажать вкладку «Соусы»")
    public void clickSaucesTab() {
        click(saucesTab);
    }

    @Step("Нажать вкладку «Начинки»")
    public void clickFillingsTab() {
        click(fillingsTab);
    }

    @Step("Получить текст активной вкладки")
    public String getActiveTabText() {
        return getText(activeTab);
    }

    @Step("Проверить, что вкладка «Булки» активна")
    public boolean isBunsTabActive() {
        return "Булки".equals(getActiveTabText());
    }

    @Step("Проверить, что вкладка «Соусы» активна")
    public boolean isSaucesTabActive() {
        return "Соусы".equals(getActiveTabText());
    }

    @Step("Проверить, что вкладка «Начинки» активна")
    public boolean isFillingsTabActive() {
        return "Начинки".equals(getActiveTabText());
    }

    @Step("Ожидать активации вкладки: {expectedText}")
    public void waitForActiveTab(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(Config.EXPLICIT_WAIT))
                .until(driver -> expectedText.equals(getActiveTabText()));
    }
}