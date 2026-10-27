package ru.stellarburgers.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.api.UserApiClient;
import ru.stellarburgers.constants.Config;
import ru.stellarburgers.models.UserModel;
import ru.stellarburgers.utils.BrowserFactory;
import ru.stellarburgers.utils.TestDataGenerator;

public class BaseUiTest {

    protected WebDriver driver;
    protected UserModel user;
    protected UserApiClient userApiClient;

    @Before
    public void setUp() {
        userApiClient = new UserApiClient();

        String browser = System.getProperty("browser", Config.DEFAULT_BROWSER);
        driver = BrowserFactory.createDriver(browser);
        driver.get(Config.BASE_URL);

        if (shouldCreateUser()) {
            createTestUser();
        }
    }

    @After
    public void tearDown() {
        try {
            if (shouldCreateUser()) {
                deleteTestUser();
            }
        } finally {
            closeBrowser();
        }
    }

    protected boolean shouldCreateUser() {
        return true;
    }

    protected void createTestUser() {
        user = UserModel.builder()
                .email(TestDataGenerator.generateEmail())
                .password(TestDataGenerator.generatePassword())
                .name(TestDataGenerator.generateName())
                .build();

        userApiClient.createUser(user);
    }

    protected void deleteTestUser() {
        if (userApiClient != null && userApiClient.getAccessToken() != null) {
            userApiClient.deleteUser();
        }
    }

    protected void closeBrowser() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Игнорируем, если браузер уже закрыт
            }
            driver = null;
        }
    }
}