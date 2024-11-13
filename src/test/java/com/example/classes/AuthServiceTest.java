package com.example.classes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.application.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private EmailService emailService;
    @Mock
    private UserService userService;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test: Register User - Success")
    void testRegisterUser_Success() {
        String username = "testUser";
        String password = "password123";
        String email = "test@example.com";
        String firstName = "Test";
        String lastName = "User";

        when(userRepository.findByUsername(username)).thenReturn(null);
        when(userRepository.findByEmail(email)).thenReturn(null);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User result = authService.registerUser(username, password, email, firstName, lastName);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals(firstName, result.getFirstName());
        assertEquals(lastName, result.getLastName());
        verify(userRepository, times(1)).save(any(User.class));
        verify(userService, times(1)).generateVerificationLink(result);
    }

    @Test
    @DisplayName("Test: Register User - Username Already Exists")
    void testRegisterUser_UsernameAlreadyExists() {
        String username = "existingUser";

        when(userRepository.findByUsername(username)).thenReturn(new User());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser(username, "password123", "test@example.com", "Test", "User");
        });

        assertEquals("Brukernavnet er allerede i bruk.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Test: Register User - Email Already Exists")
    void testRegisterUser_EmailAlreadyExists() {
        String email = "existing@example.com";

        when(userRepository.findByUsername("newUser")).thenReturn(null);
        when(userRepository.findByEmail(email)).thenReturn(new User());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser("newUser", "password123", email, "Test", "User");
        });

        assertEquals("E-posten er allerede registrert.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Test: Verify Email - Success")
    void testVerifyEmail_Success() {
        String email = "test@example.com";
        String token = "valid-token";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(userService.verifyUserByToken(token)).thenReturn(true);

        boolean result = authService.verifyEmail(email, token);

        assertTrue(result);
    }

    @Test
    @DisplayName("Test: Verify Email - Failure")
    void testVerifyEmail_Failure() {
        String email = "test@example.com";
        String token = "invalid-token";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(userService.verifyUserByToken(token)).thenReturn(false);

        boolean result = authService.verifyEmail(email, token);

        assertFalse(result);
    }

    @Test
    @DisplayName("Test: Login - Success")
    void testLogin_Success() {
        String username = "testUser";
        String password = "password123";
        User user = new User();
        user.setUsername(username);
        user.setHashedPassword(password);

        when(userRepository.findByUsername(username)).thenReturn(user);

        boolean result = authService.login(username, password);

        assertTrue(result);
        assertTrue(user.isAuthenticated());
    }

    @Test
    @DisplayName("Test: Login - Failure (Invalid Password)")
    void testLogin_Failure_InvalidPassword() {
        String username = "testUser";
        String password = "incorrectPassword";
        User user = new User();
        user.setUsername(username);
        user.setHashedPassword("password123");

        when(userRepository.findByUsername(username)).thenReturn(user);

        boolean result = authService.login(username, password);

        assertFalse(result);
        assertFalse(user.isAuthenticated());
    }

    @Test
    @DisplayName("Test: Login - Failure (User Not Found)")
    void testLogin_Failure_UserNotFound() {
        when(userRepository.findByUsername("testUser")).thenReturn(null);

        boolean result = authService.login("testUser", "password123");

        assertFalse(result);
    }
}
