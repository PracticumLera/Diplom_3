package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.base.BaseUiTest;
import ru.stellarburgers.constants.Config;
import ru.stellarburgers.models.UserModel;
import ru.stellarburgers.steps.LoginSteps;
import ru.stellarburgers.steps.RegisterSteps;
import ru.stellarburgers.utils.TestDataGenerator;

@Epic("Stellar Burgers UI")
@Feature("Регистрация")
public class RegistrationTest extends BaseUiTest {

    private RegisterSteps registerSteps;
    private LoginSteps loginSteps;

    @Override
    protected boolean shouldCreateUser() {
        return false;
    }

    @Before
    public void initSteps() {
        registerSteps = new RegisterSteps(driver);
        loginSteps = new LoginSteps(driver);
        driver.get(Config.REGISTER_URL);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации нового пользователя")
    public void successRegistrationTest() {
        String createdEmail = TestDataGenerator.generateEmail();
        String createdPassword = TestDataGenerator.generatePassword();
        String name = TestDataGenerator.generateName();

        registerSteps.registerUser(name, createdEmail, createdPassword);
        loginSteps.verifyOnLoginPage();

        UserModel createdUser = UserModel.builder()
                .email(createdEmail)
                .password(createdPassword)
                .name(name)
                .build();

        userApiClient.loginUser(createdUser);
        userApiClient.deleteUser();
    }

    @Test
    @DisplayName("Ошибка при пароле менее 6 символов")
    @Description("Проверка ошибки валидации пароля")
    public void registrationWithShortPasswordTest() {
        String name = TestDataGenerator.generateName();
        String email = TestDataGenerator.generateEmail();
        String shortPassword = TestDataGenerator.generateShortPassword();

        registerSteps
                .registerUser(name, email, shortPassword)
                .verifyPasswordErrorDisplayed()
                .verifyPasswordErrorText();
    }
}