package com.example.classes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.application.classes.AuthService;
import com.example.application.classes.EmailService;
import com.example.application.classes.User;
import com.example.application.classes.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private EmailService emailService;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authService = new AuthService(userRepository, emailService);
    }

    @Test
    @DisplayName("Test: Register User - Success")
    void testRegisterUser_Success() {
        String username = "testUser";
        String password = "password123";
        String email = "test@example.com";
        String firstName = "Test";
        String lastName = "User";

        // Mock the behavior of the userRepository to not find the user by username or email
        when(userRepository.findByUsername(username)).thenReturn(null);
        when(userRepository.findByEmail(email)).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(new User(username, firstName, lastName, email, password));

        User result = authService.registerUser(username, password, email, firstName, lastName);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals(firstName, result.getFirstName());
        assertEquals(lastName, result.getLastName());
        verify(userRepository, times(1)).save(any(User.class));  // Verify save is called once
    }

    @Test
    @DisplayName("Test: Register User - Username Already Exists")
    void testRegisterUser_UsernameAlreadyExists() {
        String username = "existingUser";
        String password = "password123";
        String email = "test@example.com";
        String firstName = "Test";
        String lastName = "User";

        // Mock the behavior of the userRepository to return a user with the same username
        when(userRepository.findByUsername(username)).thenReturn(new User());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser(username, password, email, firstName, lastName);
        });

        assertEquals("Brukernavnet er allerede i bruk.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));  // Verify save is not called
    }

    @Test
    @DisplayName("Test: Register User - Email Already Exists")
    void testRegisterUser_EmailAlreadyExists() {
        String username = "newUser";
        String password = "password123";
        String email = "existing@example.com";
        String firstName = "Test";
        String lastName = "User";

        // Mock the behavior of the userRepository to return a user with the same email
        when(userRepository.findByUsername(username)).thenReturn(null);
        when(userRepository.findByEmail(email)).thenReturn(new User());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.registerUser(username, password, email, firstName, lastName);
        });

        assertEquals("E-posten er allerede registrert.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));  // Verify save is not called
    }

    @Test
    @DisplayName("Test: Verify Email - Success")
    void testVerifyEmail_Success() {
        String email = "test@example.com";
        String code = "verif-";

        User user = new User();
        user.setEmail(email);
        user.setVerificationCode(code);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        boolean result = authService.verifyEmail(email, code);

        System.out.println("Email Verified: " + user.isEmailVerified());

        assertTrue(result);
        assertTrue(user.isEmailVerified());
        verify(userRepository, times(2)).save(user);
    }


    @Test
    @DisplayName("Test: Verify Email - Failure (Incorrect Code)")
    void testVerifyEmail_Failure_IncorrectCode() {
        String email = "test@example.com";
        String code = "wrong-code";

        User user = new User();
        user.setEmail(email);
        user.setVerificationCode("verif-1");


        when(userRepository.findByEmail(email)).thenReturn(user);

        boolean result = authService.verifyEmail(email, code);

        assertFalse(result);
        assertFalse(user.isEmailVerified());
        verify(userRepository, never()).save(user);
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
        String username = "testUser";
        String password = "password123";


        when(userRepository.findByUsername(username)).thenReturn(null);

        boolean result = authService.login(username, password);

        assertFalse(result);
    }
}
