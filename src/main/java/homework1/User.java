package homework1;

import org.apache.commons.lang3.StringUtils;

public class User {
    public static final String DEFAULT_LOGIN  = "Login123";
    public static final String DEFAULT_EMAIL = "user1479@yandex.ru";

    private final String login;
    private final String email;

    public User(String login, String email) {

        if (isCorrectEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("Is not correct email: " + email);
        }

        if (isEmailEqualsLogin(email, login)) {
            throw new InvalidLoginException("Login and email does not equals: " + email);
        }
        this.login = login;
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

    private boolean isCorrectEmail(String email) {
        return email.matches("\\w+@\\w+(\\.\\w+)+");
    }

    private boolean isEmailEqualsLogin(String email, String login) {
        return StringUtils.equals(email, login);
    }
}
