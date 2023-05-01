package homework2.dao;

import homework2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {
    public static final String EXIST_USER_NAME = "Boris";
    public static final String NOT_EXIST_USER_NAME = "Oleg";

    private User existUser;
    private UserDao userDao;

    @BeforeEach
    public void init() {
        existUser = new User(EXIST_USER_NAME);
        userDao = new UserDaoImpl();
    }

    @Test
    public void getExistUserByName() {
        Assertions.assertNull(userDao.getUserByName(null));
        Assertions.assertNull(userDao.getUserByName(NOT_EXIST_USER_NAME));
    }

    @Test
    public void getNotExistUserByName() {
        Assertions.assertNull(userDao.getUserByName(null));
        Assertions.assertNull(userDao.getUserByName(NOT_EXIST_USER_NAME));
    }

    @Test
    public void findAllUsers() {
        Assertions.assertEquals(3, userDao.findAllUsers().size());
        Assertions.assertTrue(userDao.findAllUsers().contains(existUser));
    }
}