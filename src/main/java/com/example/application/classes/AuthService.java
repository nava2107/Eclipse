package com.example.application.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    private EmailService emailService;

    public AuthService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public AuthService(){}

    public User registerUser(String username, String password, String email, String firstName, String lastName) {
        // Sjekk om brukernavn eller e-post allerede er i bruk
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Brukernavnet er allerede i bruk.");
        } else if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("E-posten er allerede registrert.");
        } else {
            // Oppretter brukeren om brukernavn og email er ledig
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setHashedPassword(hashPassword(password)); // Her "hashes" passordet (ikke ekte hashing men får frem intensjon om at det skal hashes)
            newUser.setEmail(email);

            // Lagre den nye brukeren i databasen
            return userRepository.save(newUser);
        }
    }

    public boolean verifyEmail(String email, String code) {
        User user = userRepository.findByEmail(email);
        if (user != null && verifyCode(user, code)) {
            user.setEmailVerified(true);
            userRepository.save(user);
            userRepository.save(user);

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

        if (user != null && password.equals(user.getHashedPassword())) {
            user.setAuthenticated(true);
            return true;
        }
        return false;
    }

    private String hashPassword(String password) {
        return password;  // Burde bruke en ordentlig hashingfunksjon, men for prosjektet vårt er ikke dette nødvendig
    }


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
