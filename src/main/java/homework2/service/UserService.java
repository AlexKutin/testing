package homework2.service;

import homework2.dao.UserDao;
import homework2.model.User;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        return userDao.getUserByName(user.getName()) != null;
    }
}
