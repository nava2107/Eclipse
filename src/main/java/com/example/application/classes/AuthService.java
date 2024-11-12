package com.example.application.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserService userService;

    @Autowired
    public AuthService(UserRepository userRepository, EmailService emailService, UserService userService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userService = userService;
    }

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
            userRepository.save(newUser);

            // Generer og send verifikasjonslenke
            userService.generateVerificationLink(newUser);

            return newUser;
        }
    }

    public boolean verifyEmail(String email, String token) {
        User user = userRepository.findByEmail(email);
        return user != null && userService.verifyUserByToken(token);
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

    public EmailService getEmailService() {
        return emailService;
    }
}
