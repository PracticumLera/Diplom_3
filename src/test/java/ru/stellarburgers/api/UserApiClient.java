package ru.stellarburgers.api;

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

    public Response createUser(UserModel user) {
        Response response = spec
                .body(user)
                .post(API_REGISTER);

        if (response.getStatusCode() == 200) {
            accessToken = response.jsonPath().getString("accessToken");
        }
        return response;
    }

    public Response loginUser(UserModel user) {
        Response response = spec
                .body(user)
                .post(API_LOGIN);

        if (response.getStatusCode() == 200) {
            accessToken = response.jsonPath().getString("accessToken");
        }
        return response;
    }

    public Response deleteUser() {
        if (accessToken == null || accessToken.isEmpty()) {
            return null;
        }
        return spec
                .header("Authorization", accessToken)
                .delete(API_USER);
    }
}