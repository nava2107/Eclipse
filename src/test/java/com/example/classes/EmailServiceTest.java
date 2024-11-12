package com.example.classes;


import com.example.application.classes.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@DisplayName("EmailService Tests")
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test: Send Verification Email")
    void testSendVerificationEmail() {
        String toEmail = "test@example.com";
        String verificationCode = "123456";

        emailService.sendVerificationEmail(toEmail, verificationCode);

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(toEmail);
        expectedMessage.setSubject("Please Verify Your Email Address");
        expectedMessage.setText("Dear User,\n\n" +
                "Thank you for registering with us! To complete your registration, please verify your email address by using the verification code below:\n\n" +
                "Verification Code: " + verificationCode + "\n\n" +
                "Alternatively, you can verify your email by clicking the following link:\n" +
                "http://localhost:60401/verify?code=" + verificationCode + "\n\n" +
                "If you did not register with us, please ignore this email.\n\n" +
                "Best regards,\nThe Eclipse Team");

        verify(mailSender, times(1)).send(expectedMessage);
    }

    @Test
    @DisplayName("Test: Send Welcome Email")
    void testSendWelcomeEmail() {
        String toEmail = "test@example.com";

        emailService.sendWelcomeEmail(toEmail);

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(toEmail);
        expectedMessage.setSubject("Welcome!");
        expectedMessage.setText("Welcome to our service!");

        verify(mailSender, times(1)).send(expectedMessage);
    }
}

