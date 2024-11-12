package com.example.classes;

import com.example.application.classes.EmailService;
import com.example.application.classes.User;
import com.example.application.classes.UserRepository;
import com.example.application.classes.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test: Generate Verification Link - Success")
    void testGenerateVerificationLink_Success() {
        User user = new User();
        user.setEmail("test@example.com");

        // Mock repository save behavior
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        userService.generateVerificationLink(user);

        assertNotNull(user.getVerificationToken());


        verify(userRepository, times(1)).save(user);
        verify(emailService, times(1)).sendVerificationEmail(eq(user.getEmail()), contains(user.getVerificationToken()));
    }

    @Test
    @DisplayName("Test: Verify User by Token - Success")
    void testVerifyUserByToken_Success() {
        String token = "valid-token";

        User user = new User();
        user.setVerificationToken(token);
        user.setEmailVerified(false);

        when(userRepository.findByVerificationToken(token)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        boolean result = userService.verifyUserByToken(token);

        assertTrue(result);
        assertTrue(user.isEmailVerified());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Test: Verify User by Token - Failure (User Not Found)")
    void testVerifyUserByToken_UserNotFound() {
        String token = "invalid-token";

        when(userRepository.findByVerificationToken(token)).thenReturn(null);


        boolean result = userService.verifyUserByToken(token);


        assertFalse(result);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Test: Verify User by Token - Failure (Already Verified)")
    void testVerifyUserByToken_AlreadyVerified() {
        String token = "valid-token";

        User user = new User();
        user.setVerificationToken(token);
        user.setEmailVerified(true);

        when(userRepository.findByVerificationToken(token)).thenReturn(user);

        boolean result = userService.verifyUserByToken(token);

        assertFalse(result);
        verify(userRepository, never()).save(any(User.class));
    }
}
