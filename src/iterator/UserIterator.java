package iterator;

import model.User;
import java.util.List;

public class UserIterator {
    private List<User> users;
    private int position = 0;

    public UserIterator(List<User> users) {
        this.users = users;
    }

    public boolean hasNext() {
        return position < users.size();
    }

    public User next() {
        return users.get(position++);
    }
}
