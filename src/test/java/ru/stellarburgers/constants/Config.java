package ru.stellarburgers.constants;

public class Config {

    public static final String BASE_URL = "https://qa-stellarburgers.education-services.ru";
    public static final String REGISTER_URL = BASE_URL + "/register";
    public static final String FORGOT_PASSWORD_URL = BASE_URL + "/forgot-password";

    public static final String API_BASE_URL = BASE_URL + "/api";
    public static final String API_REGISTER = API_BASE_URL + "/auth/register";
    public static final String API_LOGIN = API_BASE_URL + "/auth/login";
    public static final String API_USER = API_BASE_URL + "/auth/user";

    public static final int IMPLICIT_WAIT = 5;
    public static final int EXPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 15;

    public static final String DEFAULT_BROWSER =
            System.getProperty("browser", "chrome");

    public static final String YANDEX_DRIVER_PATH =
            System.getProperty("yandex.driver.path",
                    "C:/Users/valer/Downloads/yandexdriver-26.8.0.1788-win64/yandexdriver.exe");

    private Config() {
    }
}