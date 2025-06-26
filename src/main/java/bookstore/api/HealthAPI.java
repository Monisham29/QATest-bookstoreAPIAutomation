package bookstore.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthAPI {
    public static boolean isHealthy() {
        Response response = RestAssured.get("http://localhost:8000/health");
        return response.statusCode() == 200;
    }
}
