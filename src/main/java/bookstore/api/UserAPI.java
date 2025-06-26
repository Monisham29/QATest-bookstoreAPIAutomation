package bookstore.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserAPI {
    public static String login(String username, String password) {
        Response response = RestAssured.given().contentType("application/json")
            .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
            .post("http://localhost:8000/login");
        return response.jsonPath().getString("access_token");
    }
    public static void signup(String username, String password) {
        RestAssured.given().contentType("application/json")
            .body("{ \"email\": \"" + username + "\", \"password\": \"" + password + "\" }")
            .post("http://localhost:8000/signup")
            .then().statusCode(200);
    }
}
