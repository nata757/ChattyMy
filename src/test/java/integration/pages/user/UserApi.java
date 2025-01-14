package integration.pages.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserApi extends ApiBase {

    Response response;
    @Step("Registration user")
    public String registration(String email, String password, String confirmPassword, String role, int expectedStatusCode) {
        String endPoint = "/api/auth/register";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("role", role);

        response = postRequest(endPoint, expectedStatusCode, body);
        int statusCode = response.statusCode();

        if (statusCode == expectedStatusCode) {
            return "User registered successfully";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to register user: " + errorMessage;
        }
    }
    @Step("Вход через API: {email}")
    public String login(String email, String password, int expectedStatusCode) {
        String endpoint = "/api/auth/login";
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        response = postRequest(endpoint, expectedStatusCode, body);
        int code = response.statusCode();

        if (code == expectedStatusCode) {
            String refreshToken = response.jsonPath().getString("refreshToken");
            return "refreshToken: " + refreshToken;
        } else {
            String errorMessage = response.getBody().asString();
            return "Failed to login: " + errorMessage;
        }
    }

    @Step(": {refreshToken}")
    public String refreshToken(String token, int expectedStatusCode) {
        String endpoint = "/api/auth/refresh";
        Map<String, String> body = new HashMap<>();
        body.put("refreshToken", token);
        response = postRequest(endpoint, expectedStatusCode, body);
        return response.getBody().asString();
    }
}