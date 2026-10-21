package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.base.BaseUiTest;
import ru.stellarburgers.constants.Config;
import ru.stellarburgers.steps.ForgotPasswordSteps;
import ru.stellarburgers.steps.HomeSteps;
import ru.stellarburgers.steps.LoginSteps;
import ru.stellarburgers.steps.RegisterSteps;

@Epic("Stellar Burgers UI")
@Feature("Вход")
public class LoginTest extends BaseUiTest {

    private HomeSteps homeSteps;
    private LoginSteps loginSteps;
    private RegisterSteps registerSteps;
    private ForgotPasswordSteps forgotPasswordSteps;

    @Before
    public void initSteps() {
        homeSteps = new HomeSteps(driver);
        loginSteps = new LoginSteps(driver);
        registerSteps = new RegisterSteps(driver);
        forgotPasswordSteps = new ForgotPasswordSteps(driver);
    }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    @Description("Проверка входа через основную кнопку на главной странице")
    public void loginViaMainPageButtonTest() {
        driver.get(Config.BASE_URL);

        homeSteps
                .verifyHomePageLoaded()
                .clickLoginButton();

        loginSteps
                .verifyOnLoginPage()
                .login(user.getEmail(), user.getPassword());

        homeSteps.verifyLoggedIn();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа через кнопку личного кабинета")
    public void loginViaPersonalAccountButtonTest() {
        driver.get(Config.BASE_URL);

        homeSteps
                .verifyHomePageLoaded()
                .clickProfileButton();

        loginSteps
                .verifyOnLoginPage()
                .login(user.getEmail(), user.getPassword());

        homeSteps.verifyLoggedIn();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через ссылку «Войти» на странице регистрации")
    public void loginViaRegisterFormButtonTest() {
        driver.get(Config.REGISTER_URL);

        registerSteps
                .verifyRegisterPageLoaded()
                .clickLoginLink();

        loginSteps
                .verifyOnLoginPage()
                .login(user.getEmail(), user.getPassword());

        homeSteps.verifyLoggedIn();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через ссылку «Войти» на странице восстановления пароля")
    public void loginViaForgotPasswordFormButtonTest() {
        driver.get(Config.FORGOT_PASSWORD_URL);

        forgotPasswordSteps
                .verifyOnForgotPasswordPage()
                .clickLoginLink();

        loginSteps
                .verifyOnLoginPage()
                .login(user.getEmail(), user.getPassword());

        homeSteps.verifyLoggedIn();
    }
}