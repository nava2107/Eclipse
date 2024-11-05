package com.example.application.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    // Bruk konstruktørbasert injeksjon
    @Autowired
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    // Generere en unik verifikasjonslenke
    public void generateVerificationLink(User user) {
        String verificationToken = java.util.UUID.randomUUID().toString();
        user.setVerificationToken(verificationToken);
        userRepository.save(user);  // Lagre brukeren med den genererte token

        // Send verifikasjonslenke via e-post
        String verificationLink = "http://localhost:60401/verify?token=" + verificationToken;
        emailService.sendVerificationEmail(user.getEmail(), verificationLink);

    }

    // Verifiser brukeren basert på verifikasjonskoden
    public boolean verifyUserByToken(String token) {
        User user = userRepository.findByVerificationToken(token);
        if (user != null && !user.isEmailVerified()) {
            user.setEmailVerified(true);  // Sett e-poststatusen til verifisert
            userRepository.save(user);    // Lagre den oppdaterte brukeren
            return true;
        }
        return false;
    }
}
