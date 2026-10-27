# 🍔 Stellar Burgers — UI-автотесты

![Java](https://img.shields.io/badge/Java-11-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.25.0-43B02A?style=flat-square&logo=selenium&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-25A162?style=flat-square&logo=junit5&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-2.27.0-FF6A00?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![Tests](https://img.shields.io/badge/tests-9%20passed-brightgreen?style=flat-square)

Дипломный проект **Яндекс.Практикума** по специальности «QA-автоматизация»: автоматизация UI-тестирования
учебного приложения **Stellar Burgers** на Java 11 с использованием Selenium WebDriver, JUnit 4, Allure
и паттерна **Page Object**.

Тесты проверяют три ключевых сценария продукта: **регистрацию**, **вход в аккаунт** (4 способа) и
**навигацию по конструктору бургеров**. Тестовые пользователи создаются и удаляются через API,
поэтому каждый тест независим и не оставляет мусора в базе.

---

## 📑 Содержание

- [Стек технологий](#-стек-технологий)
- [Структура проекта](#-структура-проекта)
- [Тесты (9 штук)](#-тесты-9-штук)
- [Быстрый старт](#-быстрый-старт)
- [Запуск тестов](#-запуск-тестов)
- [Allure-отчёты](#-allure-отчёты)
- [Скриншоты](#-скриншоты)
- [Особенности реализации](#-особенности-реализации)
- [Основные компоненты](#-основные-компоненты)
- [Пример теста](#-пример-теста)
- [Конфигурация](#-конфигурация)

---

## 🛠 Стек технологий

| Технология | Версия | Назначение |
|---|---|---|
| ☕ **Java** | 11 | Язык программирования |
| 🌐 **Selenium WebDriver** | 4.25.0 | Управление браузером |
| ✅ **JUnit 4** | 4.13.2 | Фреймворк для тестирования |
| 🔌 **REST Assured** | 5.5.5 | API-предусловия (создание/удаление юзера) |
| 📊 **Allure** | 2.27.0 | Отчётность |
| 🧩 **Lombok** | 1.18.34 | Генерация кода (модели) |
| 📦 **Jackson** | 2.17.1 | Работа с JSON |
| 🚗 **WebDriverManager** | 5.9.2 | Автоустановка ChromeDriver |
| 🏗 **Maven** | 3.6+ | Сборка проекта и запуск тестов |

---

## 📂 Структура проекта

```text
src/test/java/ru/stellarburgers/
├── api/
│   └── UserApiClient.java              — API-клиент (регистрация/удаление юзера)
├── base/
│   ├── BasePage.java                   — базовый Page Object
│   └── BaseUiTest.java                 — базовый тест-класс
├── constants/
│   └── Config.java                     — URL-адреса и константы
├── models/
│   └── UserModel.java                  — модель пользователя
├── pages/
│   ├── MainPage.java                   — Page Object главной страницы
│   ├── LoginPage.java                  — Page Object входа
│   ├── RegisterPage.java               — Page Object регистрации
│   ├── ForgotPasswordPage.java         — Page Object восстановления пароля
│   └── ConstructorPage.java            — Page Object конструктора бургеров
├── steps/
│   ├── ConstructorSteps.java           — Steps для конструктора
│   ├── ForgotPasswordSteps.java        — Steps для восстановления пароля
│   ├── HomeSteps.java                  — Steps для главной страницы
│   ├── LoginSteps.java                 — Steps для входа
│   └── RegisterSteps.java              — Steps для регистрации
├── tests/
│   ├── RegistrationTest.java           — 2 теста регистрации
│   ├── LoginTest.java                  — 4 теста входа
│   └── ConstructorNavigationTest.java  — 3 теста конструктора
└── utils/
    ├── BrowserFactory.java             — фабрика браузеров (Chrome, Яндекс)
    └── TestDataGenerator.java          — генерация тестовых данных
```

---

## ✅ Тесты (9 штук)

**Текущий результат: 9 passed — 100% успеха.**

### Регистрация — `RegistrationTest` (2 теста)

| # | Тест | Что проверяем |
|---|---|---|
| 1 | ✅ **Успешная регистрация** | Регистрация новой учётной записи с валидными данными и переход на страницу входа |
| 2 | ✅ **Ошибка при пароле менее 6 символов** | Появление сообщения об ошибке валидации пароля |

### Вход — `LoginTest` (4 теста)

| # | Тест | Точка входа |
|---|---|---|
| 3 | ✅ **Вход через «Войти в аккаунт»** | Кнопка на главной странице |
| 4 | ✅ **Вход через «Личный кабинет»** | Ссылка в шапке сайта |
| 5 | ✅ **Вход через форму регистрации** | Ссылка «Войти» на странице `/register` |
| 6 | ✅ **Вход через форму восстановления пароля** | Ссылка «Войти» на странице `/forgot-password` |

### Конструктор — `ConstructorNavigationTest` (3 теста)

| # | Тест | Что проверяем |
|---|---|---|
| 7 | ✅ **Переход к разделу «Булки»** | Вкладка становится активной |
| 8 | ✅ **Переход к разделу «Соусы»** | Вкладка становится активной |
| 9 | ✅ **Переход к разделу «Начинки»** | Вкладка становится активной |

---

## 🚀 Быстрый старт

### Требования

- **Java 11+** — [скачать](https://adoptium.net/)
- **Maven 3.6+** — [скачать](https://maven.apache.org/download.cgi)
- **Google Chrome** — браузер для тестирования (по умолчанию)
- **Яндекс Браузер** — опционально

Проверить окружение:

```bash
java -version
mvn -version
```

Тестовый стенд: <https://qa-stellarburgers.education-services.ru>

### Установка Яндекс Браузера и драйвера

1. Установить **Яндекс Браузер**.
2. Скачать `yandexdriver.exe` со страницы
   [GitHub releases](https://github.com/yandex/YandexDriver/releases).
3. Указать пути в `Config.java`:

```java
public static final String YANDEX_DRIVER_PATH =
        "C:/Users/вашеимя/Downloads/yandexdriver-26.8.0.1788-win64/yandexdriver.exe";
public static final String YANDEX_BROWSER_PATH =
        "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe";
```

> 💡 Пути можно не менять в коде, а передать параметрами запуска:
> `-Dyandex.driver.path=... -Dyandex.browser.path=...`

---

## 🏃 Запуск тестов

### Основные команды

| Команда | Что делает |
|---|---|
| `mvn clean test` | Все тесты, Chrome по умолчанию |
| `mvn clean test -Dbrowser=chrome` | Все тесты в Google Chrome |
| `mvn clean test -Dbrowser=yandex` | Все тесты в Яндекс Браузере |
| `mvn clean test -Dtest=RegistrationTest` | Только тесты регистрации |
| `mvn clean test -Dtest=LoginTest` | Только тесты входа |
| `mvn clean test -Dtest=ConstructorNavigationTest` | Только тесты конструктора |

### Примеры

```bash
# Все тесты в Chrome
mvn clean test

# Конкретный браузер
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=yandex

# Конкретный тест-класс
mvn clean test -Dtest=RegistrationTest
mvn clean test -Dtest=LoginTest
mvn clean test -Dtest=ConstructorNavigationTest
```

---

## 📊 Allure-отчёты

### Генерация отчёта

```bash
mvn allure:report
```

### Просмотр отчёта в браузере

```bash
mvn allure:serve
```

После выполнения команды отчёт автоматически откроется в браузере.

### Что внутри отчёта

- **Overview** — статистика выполнения тестов
- **Suites** — разбиение тестов по категориям (регистрация, вход, конструктор)
- **Graphs** — графики результатов
- **Timeline** — временная шкала выполнения
- **Behaviors** — тесты, сгруппированные по Epic/Feature

---

## 📸 Скриншоты

![Allure Overview](screenshots/allure-overview.png)

*Overview: 9 тестов, 100% успеха*

![Allure Suites](screenshots/allure-suites.png)

*Suites: детализация по классам тестов*

---

## 💡 Особенности реализации

- ✅ **API + UI тестирование** — тестовые данные создаются и удаляются через API для скорости и надёжности
- ✅ **Page Object Pattern** — инкапсуляция элементов и методов взаимодействия со страницами
- ✅ **Steps** — обёртки над Page Objects для читаемых тестов
- ✅ **Независимые тесты** — каждый тест создаёт своего пользователя в `setUp()` и удаляет в `tearDown()`
- ✅ **Явное ожидание** — `WebDriverWait` для надёжной работы с динамическими элементами
- ✅ **Allure интеграция** — `@Epic`, `@Feature`, `@DisplayName`, `@Description` для читаемых отчётов
- ✅ **WebDriverManager** — автоматическая загрузка ChromeDriver, без ручной настройки
- ✅ **Генерация тестовых данных** — уникальные email/пароль/имя для каждого теста
- ✅ **Поддержка Chrome и Яндекс Браузера** — выбор через `-Dbrowser=...`

---

## 🧩 Основные компоненты

### `BaseUiTest`

Базовый класс для всех тестов. Автоматически выполняет:

1. Инициализирует `WebDriver` в `setUp()`
2. Создаёт тестового пользователя через API
3. Получает `accessToken` для авторизации
4. Удаляет пользователя через API в `tearDown()`
5. Закрывает браузер в `tearDown()`

### `BasePage`

Базовый Page Object с вспомогательными методами:

| Метод | Назначение |
|---|---|
| `find(By locator)` | Поиск видимого элемента с явным ожиданием |
| `click(By locator)` | Клик после проверки кликабельности |
| `type(By locator, String text)` | Ввод текста с очисткой поля |
| `getText(By locator)` | Получение текста элемента |
| `isDisplayed(By locator)` | Проверка видимости |
| `waitForElementVisible(By locator)` | Явное ожидание видимости |

### `UserApiClient`

REST API-клиент для работы с пользователями:

| Метод | Назначение |
|---|---|
| `createUser(UserModel user)` | Регистрация пользователя и получение токена |
| `loginUser(UserModel user)` | Авторизация и получение токена |
| `deleteUser()` | Удаление пользователя |

### `UserModel`

Модель пользователя с Lombok:

```java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {
    private String email;
    private String password;
    private String name;
}
```

### `TestDataGenerator`

Генератор уникальных тестовых данных:

| Метод | Формат |
|---|---|
| `generateEmail()` | `test_UUID@yandex.ru` |
| `generatePassword()` | `Pass_UUID` |
| `generateName()` | `User_UUID` |
| `generateShortPassword()` | `123` (для negative-тестов) |

### `BrowserFactory`

Фабрика для создания `WebDriver`:

| Метод | Назначение |
|---|---|
| `createDriver(String browserName)` | Создание драйвера для указанного браузера |

Поддерживаемые браузеры: `chrome`, `yandex`. Автоматически устанавливает таймауты.

### Page Objects

<details>
<summary><b>MainPage</b> — главная страница</summary>

| Метод | Назначение |
|---|---|
| `clickLoginButton()` | Клик на кнопку «Войти в аккаунт» |
| `clickPersonalAccountLink()` | Клик на ссылку «Личный Кабинет» |
| `isOrderButtonDisplayed()` | Проверка видимости кнопки «Оформить заказ» |
| `isMainPageLoaded()` | Проверка загрузки страницы |
| `waitForOrderButtonVisible()` | Ожидание видимости кнопки |

</details>

<details>
<summary><b>LoginPage</b> — страница входа</summary>

| Метод | Назначение |
|---|---|
| `enterEmail(String email)` | Ввод email |
| `enterPassword(String password)` | Ввод пароля |
| `clickLoginButton()` | Клик на кнопку «Войти» |
| `login(String email, String password)` | Комплексный метод входа |
| `clickRegisterLink()` | Переход на регистрацию |
| `clickForgotPasswordLink()` | Переход на восстановление пароля |
| `isLoginPageLoaded()` | Проверка загрузки страницы |

</details>

<details>
<summary><b>RegisterPage</b> — страница регистрации</summary>

| Метод | Назначение |
|---|---|
| `enterName(String name)` | Ввод имени |
| `enterEmail(String email)` | Ввод email |
| `enterPassword(String password)` | Ввод пароля |
| `clickRegisterButton()` | Клик на кнопку «Зарегистрироваться» |
| `register(String name, String email, String password)` | Комплексный метод регистрации |
| `clickLoginLink()` | Переход на вход |
| `isRegisterPageLoaded()` | Проверка загрузки страницы |
| `isPasswordErrorDisplayed()` | Проверка ошибки пароля |
| `getPasswordErrorText()` | Получение текста ошибки |

</details>

<details>
<summary><b>ForgotPasswordPage</b> — страница восстановления пароля</summary>

| Метод | Назначение |
|---|---|
| `clickLoginLink()` | Переход на вход |
| `isForgotPasswordPageLoaded()` | Проверка загрузки страницы |

</details>

<details>
<summary><b>ConstructorPage</b> — конструктор бургеров</summary>

| Метод | Назначение |
|---|---|
| `clickBunsTab()` | Переход на вкладку «Булки» |
| `clickSaucesTab()` | Переход на вкладку «Соусы» |
| `clickFillingsTab()` | Переход на вкладку «Начинки» |
| `getActiveTabText()` | Получение названия активной вкладки |
| `isBunsTabActive()` | Проверка активности вкладки «Булки» |
| `isSaucesTabActive()` | Проверка активности вкладки «Соусы» |
| `isFillingsTabActive()` | Проверка активности вкладки «Начинки» |
| `waitForActiveTab(String expectedText)` | Ожидание смены активной вкладки |

</details>

---

## 📝 Пример теста

```java
@Epic("Stellar Burgers UI")
@Feature("Регистрация")
public class RegistrationTest extends BaseUiTest {

    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Override
    protected boolean shouldCreateUser() {
        return false;
    }

    @Before
    public void initPages() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        driver.get(Config.REGISTER_URL);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации нового пользователя")
    public void successRegistrationTest() {
        String name = TestDataGenerator.generateName();
        String email = TestDataGenerator.generateEmail();
        String password = TestDataGenerator.generatePassword();

        registerPage.register(name, email, password);

        assertTrue("После регистрации должен быть переход на страницу входа",
                loginPage.isLoginPageLoaded());
    }
}
```

---

## 🔧 Конфигурация

Файл `Config.java` содержит:

```java
// URL-адреса
public static final String BASE_URL = "https://qa-stellarburgers.education-services.ru";
public static final String REGISTER_URL = BASE_URL + "/register";
public static final String FORGOT_PASSWORD_URL = BASE_URL + "/forgot-password";

// API-адреса
public static final String API_BASE_URL = BASE_URL + "/api";
public static final String API_REGISTER = API_BASE_URL + "/auth/register";
public static final String API_LOGIN = API_BASE_URL + "/auth/login";
public static final String API_USER = API_BASE_URL + "/auth/user";

// Таймауты
public static final int IMPLICIT_WAIT = 5;
public static final int EXPLICIT_WAIT = 20;
public static final int PAGE_LOAD_TIMEOUT = 30;

// Браузер
public static final String DEFAULT_BROWSER = System.getProperty("browser", "chrome");
public static final String YANDEX_DRIVER_PATH = System.getProperty("yandex.driver.path",
        "C:/Users/valer/Downloads/yandexdriver-26.8.0.1788-win64/yandexdriver.exe");
public static final String YANDEX_BROWSER_PATH = System.getProperty("yandex.browser.path",
        "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
```

---

<div align="center">

**Проект создан как финальный диплом Яндекс.Практикума по QA-автоматизации.**

Java 11 · Selenium · JUnit 4 · Allure · Page Object

</div>
