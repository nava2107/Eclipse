package com.example.classes;

import com.example.application.classes.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    void testSendVerificationEmail() {
        String toEmail = "user@example.com";
        String verificationLink = "http://example.com/verify";

        emailService.sendVerificationEmail(toEmail, verificationLink);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendWelcomeEmail() {
        String toEmail = "user@example.com";

        emailService.sendWelcomeEmail(toEmail);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
