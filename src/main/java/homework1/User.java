package homework1;

import org.apache.commons.lang3.StringUtils;

public class User {
    public static final String DEFAULT_LOGIN  = "Login123";
    public static final String DEFAULT_EMAIL = "user1479@yandex.ru";

    private final String login;
    private final String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public User() {
        login = DEFAULT_LOGIN;
        email = DEFAULT_EMAIL;
    }

    public static boolean isCorrectEmail(String email) {
        return email.matches("\\w+@\\w+(\\.\\w+)+");
    }

    public boolean isEmailEqualsLogin() {
        return StringUtils.equals(email, login);
    }
}
