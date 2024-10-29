package com.example.application.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    // Bruk konstruktørbasert injeksjon
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Generer en unik verifikasjonskode for brukeren (dette kan være en tilfeldig generert kode)
    public void generateVerificationCode(User user) {
        String verificationCode = java.util.UUID.randomUUID().toString();
        user.setVerificationCode(verificationCode);
        userRepository.save(user);  // Lagre brukeren med den genererte koden
    }

    // Verifiser brukeren basert på verifikasjonskoden
    public boolean verifyUserByCode(String code) {
        User user = userRepository.findByVerificationCode(code);
        if (user != null && !user.isEmailVerified()) {
            user.setEmailVerified(true);  // Sett e-poststatusen til verifisert
            userRepository.save(user);    // Lagre den oppdaterte brukeren
            return true;
        }
        return false;
    }
}
