package com.example.application.classes;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // Denne klassen skal brukes for å sende ulike mailer

    public void sendVerificationEmail(String email, String verificationCode) {

        System.out.println("Sender e-post til: " + email);
        System.out.println("Din bekreftelseskode: " + verificationCode);
        System.out.println("Klikk på lenken for å bekrefte e-posten: ");
        System.out.println("http://localhost:8080/verify?email=" + email + "&code=" + verificationCode);
    }


    public void sendResetPasswordEmail(String email, String resetToken) {
        System.out.println("Sender tilbakestillingspassord-e-post til: " + email);
        System.out.println("Din tilbakestillingskode: " + resetToken);
        System.out.println("Klikk på lenken for å tilbakestille passordet: ");
        System.out.println("http://localhost:8080/reset-password?email=" + email + "&token=" + resetToken);
    }

    public void sendWelcomeEmail(String email) {
        System.out.println("Sender velkomst-e-post til: " + email);
        System.out.println("Velkommen til vår tjeneste!");
    }

}