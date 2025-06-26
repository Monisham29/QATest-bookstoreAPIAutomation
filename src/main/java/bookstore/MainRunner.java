package bookstore;

import bookstore.api.BookAPI;
import bookstore.api.UserAPI;
import bookstore.models.Book;
import bookstore.utils.TokenUtil;

public class MainRunner {
    public static void main(String[] args) {
        String token = UserAPI.login("testuser", "testpass");
        TokenUtil.setToken(token);
        Book book = new Book("Selenium Simplified", "Alan Richardson", "Automation");
        BookAPI.createBook(token, book);
    }
}
