package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    public static final String testLogin = "Alex_195";
    public static final String testEmail = "alex195@yandex.ru";

    @Test
    public void createUserByTwoParams() {
        User user = new User(testLogin, testEmail);
        Assertions.assertEquals(testLogin, user.getLogin());
        Assertions.assertEquals(testEmail, user.getEmail());

    }

    @Test
    public void createDefaultUser() {
        User user = new User();
        Assertions.assertEquals(User.DEFAULT_LOGIN, user.getLogin());
        Assertions.assertEquals(User.DEFAULT_EMAIL, user.getEmail());
    }

    @Test
    public void checkEmailIsCorrect() {
        Assertions.assertThrows(InvalidEmailException.class, () -> new User(testLogin, "user.com#ya.ru"));
        Assertions.assertThrows(InvalidEmailException.class, () -> new User(testLogin, "@user"));
        Assertions.assertThrows(InvalidEmailException.class, () -> new User(testLogin, "test@user."));
        Assertions.assertDoesNotThrow(() -> new User(testLogin, testEmail));
        Assertions.assertDoesNotThrow(() -> new User());
    }

    @Test
    public void checkEmailsEqualsLogin() {
        Assertions.assertDoesNotThrow(() -> new User());
        Assertions.assertThrows(InvalidLoginException.class, () -> new User(User.DEFAULT_EMAIL, User.DEFAULT_EMAIL));
    }
}