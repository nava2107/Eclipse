package com.example.application.classes;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Method to send a verification email
    public void sendVerificationEmail(String toEmail, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Please Verify Your Email Address");
        message.setText("Dear User,\n\n" +
                "Thank you for registering with us! To complete your registration, please verify your email address by using the verification code below:\n\n" +
                "Verification Code: " + verificationCode + "\n\n" +
                "Alternatively, you can verify your email by clicking the following link:\n" +
                "http://localhost:60401/verify?code=" + verificationCode + "\n\n" +
                "If you did not register with us, please ignore this email.\n\n" +
                "Best regards,\nThe Eclipse Team");
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