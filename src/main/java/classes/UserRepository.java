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

    public int nextId() {
        return nextId;
    }

}
