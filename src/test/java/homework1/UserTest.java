package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(User.isCorrectEmail(User.DEFAULT_EMAIL));
        assertTrue(User.isCorrectEmail(testEmail));
        assertFalse(User.isCorrectEmail("@user"));
        assertFalse(User.isCorrectEmail("test@user."));
        assertFalse(User.isCorrectEmail("user.com#ya.ru"));
    }

    @Test
    public void checkEmailsEqualsLogin() {
        User user1 = new User();
        Assertions.assertFalse(user1.isEmailEqualsLogin());

        User user2 = new User(User.DEFAULT_LOGIN, User.DEFAULT_LOGIN);
        Assertions.assertTrue(user2.isEmailEqualsLogin());
    }
}