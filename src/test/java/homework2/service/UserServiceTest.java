package homework2.service;

import homework2.dao.UserDao;
import homework2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    public static final String EXIST_USER_NAME = "Boris";
    public static final String NOT_EXIST_USER_NAME = "Oleg";

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void initEach() {
        userService = new UserService(userDaoMock);
    }

    @Test
    void checkUserExistIsTrue() {
        User existUser = new User(EXIST_USER_NAME);
        when(userDaoMock.getUserByName(EXIST_USER_NAME)).thenReturn(existUser);

        Assertions.assertTrue(userService.checkUserExist(existUser));
        verify(userDaoMock, times(1)).getUserByName(EXIST_USER_NAME);
    }

    @Test
    void checkUserExistIsFalse() {
        User notExistUser = new User(NOT_EXIST_USER_NAME);
        when(userDaoMock.getUserByName(NOT_EXIST_USER_NAME)).thenReturn(null);

        Assertions.assertFalse(userService.checkUserExist(notExistUser));
        verify(userDaoMock, times(1)).getUserByName(NOT_EXIST_USER_NAME);
    }
}