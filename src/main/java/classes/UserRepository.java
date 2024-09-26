package classes;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    public void add(User user) {
        users.put(user.getUserId(), user);
        nextId++;
    }

    public User findByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void update(User user) {
        if (users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
        }
    }

    public int nextId() {
        return nextId;
    }

}
