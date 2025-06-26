package bookstore.api;

import bookstore.models.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookAPI {

    public static Response createBook(String token, Book book) {
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
            .body(book)
            .post("http://localhost:8000/books/");
    }

    public static int createBookAndReturnId(String token, Book book) {
        return createBook(token, book)
                .then().statusCode(200)
                .extract().path("id");
    }

    public static Response updateBook(String token, int bookId, Book updateData) {
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
            .body(updateData)
            .put("http://localhost:8000/books/" + bookId);
    }

    public static Response deleteBook(String token, int bookId) {
        return RestAssured.given()
            .header("Authorization", "Bearer " + token)
            .delete("http://localhost:8000/books/" + bookId);
    }

    public static Response getBookById(String token, int bookId) {
        return RestAssured.given()
            .header("Authorization", "Bearer " + token)
            .get("http://localhost:8000/books/" + bookId);
    }

    public static Response getAllBooks(String token) {
        return RestAssured.given()
            .header("Authorization", "Bearer " + token)
            .get("http://localhost:8000/books/");
    }
}
