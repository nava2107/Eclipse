package com.example.application.classes;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> origin/emailservice
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    private EmailService emailService;

    public AuthService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User registerUser(String username, String password, String email, String firstName, String lastName) {
        if (userRepository.findByUsername(username) != null || userRepository.findByEmail(email) != null) {
            throw new RuntimeException("Username or email already in use");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setHashedPassword(password); // Pass på å hashe passordet
        newUser.setEmail(email);

        // Lagre den nye brukeren i databasen
<<<<<<< HEAD
        return userRepository.save(newUser); // save() kommer fra JpaRepository
=======
        return userRepository.save(newUser);
>>>>>>> origin/emailservice
    }

    public boolean verifyEmail(String email, String code) {
        User user = userRepository.findByEmail(email);
        if (user != null && verifyCode(user, code)) {
            user.setEmailVerified(true);
<<<<<<< HEAD
            userRepository.save(user); // Bruk save() til å oppdatere brukeren
=======
            userRepository.save(user); // Bruk save() i stedet for update()
>>>>>>> origin/emailservice
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

<<<<<<< HEAD
=======

>>>>>>> origin/emailservice
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
