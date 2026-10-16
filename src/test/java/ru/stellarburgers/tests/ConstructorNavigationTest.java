package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.base.BaseUiTest;
import ru.stellarburgers.constants.Config;
import ru.stellarburgers.steps.ConstructorSteps;

@Epic("Stellar Burgers UI")
@Feature("Конструктор")
public class ConstructorNavigationTest extends BaseUiTest {

    private ConstructorSteps constructorSteps;

    @Override
    protected boolean shouldCreateUser() {
        return false;
    }

    @Before
    public void initSteps() {
        constructorSteps = new ConstructorSteps(driver);
        driver.get(Config.BASE_URL);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка перехода на вкладку «Булки» в конструкторе")
    public void switchToBunsTabTest() {
        constructorSteps
                .switchToSauces()
                .switchToBuns();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка перехода на вкладку «Соусы» в конструкторе")
    public void switchToSaucesTabTest() {
        constructorSteps.switchToSauces();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка перехода на вкладку «Начинки» в конструкторе")
    public void switchToFillingsTabTest() {
        constructorSteps.switchToFillings();
    }
}