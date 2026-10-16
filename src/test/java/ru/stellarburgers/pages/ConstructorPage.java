package ru.stellarburgers.pages;

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

    public void clickBunsTab() {
        click(bunsTab);
    }

    public void clickSaucesTab() {
        click(saucesTab);
    }

    public void clickFillingsTab() {
        click(fillingsTab);
    }

    public String getActiveTabText() {
        return getText(activeTab);
    }

    public boolean isBunsTabActive() {
        return "Булки".equals(getActiveTabText());
    }

    public boolean isSaucesTabActive() {
        return "Соусы".equals(getActiveTabText());
    }

    public boolean isFillingsTabActive() {
        return "Начинки".equals(getActiveTabText());
    }

    public void waitForActiveTab(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(Config.EXPLICIT_WAIT))
                .until(driver -> expectedText.equals(getActiveTabText()));
    }
}