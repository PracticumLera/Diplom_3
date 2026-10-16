package ru.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import ru.stellarburgers.models.UserModel;

import static ru.stellarburgers.constants.Config.*;

public class UserApiClient {

    private final RequestSpecification spec;

    @Setter
    @Getter
    private String accessToken;

    public UserApiClient() {
        RestAssured.baseURI = BASE_URL;
        this.spec = RestAssured.given()
                .header("Content-Type", "application/json");
    }

    @Step("Создание пользователя через API: {user.email}")
    public Response createUser(UserModel user) {
        Response response = spec
                .body(user)
                .post(API_REGISTER);

        if (response.getStatusCode() == 200) {
            accessToken = response.jsonPath().getString("accessToken");
        }
        return response;
    }

    @Step("Логин пользователя через API: {user.email}")
    public Response loginUser(UserModel user) {
        Response response = spec
                .body(user)
                .post(API_LOGIN);

        if (response.getStatusCode() == 200) {
            accessToken = response.jsonPath().getString("accessToken");
        }
        return response;
    }

    @Step("Удаление пользователя через API")
    public Response deleteUser() {
        if (accessToken == null || accessToken.isEmpty()) {
            return null;
        }
        return spec
                .header("Authorization", accessToken)
                .delete(API_USER);
    }
}