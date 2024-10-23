package com.example.application.classes;
<<<<<<< HEAD
=======

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
>>>>>>> origin/emailservice
import org.springframework.stereotype.Service;

@Service
public class EmailService {

<<<<<<< HEAD
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
=======
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Method to send a verification email
    public void sendVerificationEmail(String toEmail, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Verify your email address");
        message.setText("Din bekreftelseskode er: " + verificationCode +
                "\nKlikk på lenken for å bekrefte e-posten: " +
                "http://localhost:60401/verify?code=" + verificationCode);

        try {
            mailSender.send(message);
            System.out.println("Verification email sent to: " + toEmail);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

    // Method to send a welcome email
    public void sendWelcomeEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome!");
        message.setText("Velkommen til vår tjeneste!");

        try {
            mailSender.send(message);
            System.out.println("Welcome email sent to: " + toEmail);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

    // Method to send a reset password email
    public void sendResetPasswordEmail(String toEmail, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Reset your password");
        message.setText("Din tilbakestillingskode er: " + resetToken +
                "\nKlikk på lenken for å tilbakestille passordet: " +
                "http://localhost:60401/reset-password?token=" + resetToken);

        try {
            mailSender.send(message);
            System.out.println("Reset password email sent to: " + toEmail);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
>>>>>>> origin/emailservice
