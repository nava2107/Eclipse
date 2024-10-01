package classes;

public class AuthService {

    private UserRepository userRepository;
    private EmailService emailService;

    public AuthService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User register(String username, String firstName, String lastName, String email, String password) {
        String hashedPassword = hashPassword(password);
        int userId = generateUserId();
        User newUser = new User(userId, username, firstName, lastName, email, hashedPassword);


        userRepository.add(newUser);

        String verificationCode = generateVerificationCode(newUser);


        emailService.sendVerificationEmail(newUser.getEmail(), verificationCode);

        return newUser;
    }


    public boolean verifyEmail(String email, String code) {
        User user = userRepository.findByEmail(email);
        if (user != null && verifyCode(user, code)) {
            user.setEmailVerified(true);
            userRepository.update(user);
            return true;
        }
        return false;
    }


    private String generateVerificationCode(User user) {
        return "verif-" + user.getUserId();
    }

    private boolean verifyCode(User user, String code) {
        String expectedCode = generateVerificationCode(user);
        return expectedCode.equals(code);
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.authenticate(password)) {
            if (!user.isEmailVerified()) {
                System.out.println("E-posten er ikke bekreftet!");
                return false;
            }
            user.setAuthenticated(true);
            return true;
        }
        return false;
    }


    private String hashPassword(String password) {
        return password;  // Burde bruke en ordentlig hashingfunksjon
    }


    private int generateUserId() {
        return userRepository.nextId();
    }

}
