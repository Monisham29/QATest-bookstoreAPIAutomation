package bookstore.utils;

public class TokenUtil {
    private static String token;

    public static void setToken(String authToken) {
        token = authToken;
    }

    public static String getToken() {
        return token;
    }

    public static boolean isTokenAvailable() {
        return token != null && !token.isEmpty();
    }
}
