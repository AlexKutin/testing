package homework2.dao;

import homework2.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final List<User> users;

    public UserDaoImpl() {
        this.users = new ArrayList<>();
        users.add(new User("Alex"));
        users.add(new User("Boris"));
        users.add(new User("Victor"));
    }

    @Override
    public User getUserByName(String name) {

        for (User user : users) {
            if (StringUtils.equals(user.getName(), name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return Collections.unmodifiableList(users);
    }
}
