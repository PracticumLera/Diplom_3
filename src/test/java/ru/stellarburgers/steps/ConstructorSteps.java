package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.pages.ConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorSteps {

    private final ConstructorPage constructorPage;

    public ConstructorSteps(WebDriver driver) {
        this.constructorPage = new ConstructorPage(driver);
    }

    @Step("Переключиться на вкладку «Булки»")
    public ConstructorSteps switchToBuns() {
        constructorPage.clickBunsTab();
        constructorPage.waitForActiveTab("Булки");
        assertTrue("Вкладка «Булки» не активна", constructorPage.isBunsTabActive());
        return this;
    }

    @Step("Переключиться на вкладку «Соусы»")
    public ConstructorSteps switchToSauces() {
        constructorPage.clickSaucesTab();
        constructorPage.waitForActiveTab("Соусы");
        assertTrue("Вкладка «Соусы» не активна", constructorPage.isSaucesTabActive());
        return this;
    }

    @Step("Переключиться на вкладку «Начинки»")
    public ConstructorSteps switchToFillings() {
        constructorPage.clickFillingsTab();
        constructorPage.waitForActiveTab("Начинки");
        assertTrue("Вкладка «Начинки» не активна", constructorPage.isFillingsTabActive());
        return this;
    }
}
