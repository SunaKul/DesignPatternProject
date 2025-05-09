package iterator;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public UserIterator createIterator() {
        return new UserIterator(users);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
