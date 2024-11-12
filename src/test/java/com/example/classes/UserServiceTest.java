package com.example.classes;


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
import static org.mockito.Mockito.*;

@DisplayName("UserService Tests")
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test: Generate Verification Code")
    void testGenerateVerificationCode() {
        User user = new User();
        userService.generateVerificationCode(user);

        assertNotNull(user.getVerificationCode(), "Verification code should not be null");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Test: Verify User by Code - Success")
    void testVerifyUserByCode_Success() {
        String code = "valid-code";
        User user = new User();
        user.setVerificationCode(code);
        user.setEmailVerified(false);

        when(userRepository.findByVerificationCode(code)).thenReturn(user);

        boolean isVerified = userService.verifyUserByCode(code);

        assertTrue(isVerified, "User should be verified successfully");
        assertTrue(user.isEmailVerified(), "User email should be set as verified");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Test: Verify User by Code - Failure")
    void testVerifyUserByCode_Failure() {
        String code = "invalid-code";
        when(userRepository.findByVerificationCode(code)).thenReturn(null);

        boolean isVerified = userService.verifyUserByCode(code);

        assertFalse(isVerified, "Verification should fail for invalid code");
        verify(userRepository, never()).save(any(User.class));
    }
}

