package classes;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String username, String email, String password) {
        String hashedPassword = hashPassword(password);
        int userId = generateUserId();
        User newUser = new User(userId, username, email, hashedPassword);
        userRepository.add(newUser);
        return newUser;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.authenticate(password)) {
            user.setAuthenticated(true);
            return true;
        }
        return false;
    }

    private String hashPassword(String password) {
        return password;
    }

    private int generateUserId() {
        return userRepository.nextId();
    }

}
