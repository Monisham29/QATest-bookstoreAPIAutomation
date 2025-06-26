package bookStore;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bookstore.api.BookAPI;
import bookstore.api.HealthAPI;
import bookstore.api.UserAPI;
import bookstore.models.Book;
import bookstore.utils.TokenUtil;

public class BookstoreTestSuite {

    @BeforeClass
    public void setup() {
        String token = UserAPI.login("testuser", "testpass");
        TokenUtil.setToken(token);
    }

    @Test
    public void testHealthCheck() {
        Assert.assertTrue(HealthAPI.isHealthy(), "API health check failed!");
    }

    @Test
    public void testBookCreation() {
        Assert.assertTrue(TokenUtil.isTokenAvailable(), "Token not available!");
        Book book = new Book("Effective Java", "Joshua Bloch", "Programming");
        BookAPI.createBook(TokenUtil.getToken(), book);
    }
    @Test
    public void testGetBookById() {
        Book book = new Book("API Design", "Martin Fowler", "Architecture");
        int bookId = BookAPI.createBookAndReturnId(TokenUtil.getToken(), book);

        BookAPI.getBookById(TokenUtil.getToken(), bookId)
               .then().statusCode(200)
               .and().body("title", org.hamcrest.Matchers.equalTo("API Design"));
    }

    @Test
    public void testGetAllBooks() {
        BookAPI.getAllBooks(TokenUtil.getToken())
               .then().statusCode(200)
               .and().body("size()", org.hamcrest.Matchers.greaterThanOrEqualTo(0));
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Delete Me", "Author X", "Testing");
        int bookId = BookAPI.createBookAndReturnId(TokenUtil.getToken(), book);

        BookAPI.deleteBook(TokenUtil.getToken(), bookId)
               .then().statusCode(200)
               .and().body("message", org.hamcrest.Matchers.equalTo("Book deleted successfully"));

        // Confirm deletion
        BookAPI.getBookById(TokenUtil.getToken(), bookId)
               .then().statusCode(404);
    }

    @Test
    public void testUserSignupAndLogin() {
        String email = "testuser@example.com";
        String password = "securepassword";

        // Signup (optional: handle 400 if user already exists)
        try {
            UserAPI.signup(email, password);
        } catch (Exception ignored) {}

        // Login
        String token = UserAPI.login(email, password);
        Assert.assertNotNull(token, "Login failed or token is null");
        TokenUtil.setToken(token);
    }


}
