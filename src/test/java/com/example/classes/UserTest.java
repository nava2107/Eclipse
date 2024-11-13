package com.example.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.application.classes.User;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Class Tests")
class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("jdoe", "John", "Doe", "jdoe@example.com", "hashedpassword");
        System.out.println("Set up User object with username: " + user.getUsername());
    }

    @Test
    @DisplayName("test: should initialize user with correct properties")
    void testUserInitialization() {
        System.out.println("Running testUserInitialization");
        assertEquals("jdoe", user.getUsername());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("jdoe@example.com", user.getEmail());
        assertEquals("hashedpassword", user.getHashedPassword());
        assertTrue(user.isActive());
        assertFalse(user.isAuthenticated());
        assertFalse(user.isEmailVerified());
        assertFalse(user.isAdmin());
        assertTrue(user.getDevices().isEmpty());
        System.out.println("testUserInitialization passed");
    }

    @Test
    @DisplayName("test: should set email verification status to true")
    void testSetEmailVerified() {
        System.out.println("Running testSetEmailVerified");
        user.setEmailVerified(true);
        assertTrue(user.isEmailVerified());
        assertTrue(user.isActive());
        System.out.println("Email verified: " + user.isEmailVerified() + ", User active: " + user.isActive());
    }

    @Test
    @DisplayName("test: should authenticate successfully with correct password")
    void testAuthenticateSuccess() {
        System.out.println("Running testAuthenticateSuccess");
        boolean result = user.authenticate("hashedpassword");
        assertTrue(result);
        System.out.println("Authentication with correct password passed: " + result);
    }

    @Test
    @DisplayName("test: should fail authentication with incorrect password")
    void testAuthenticateFailure() {
        System.out.println("Running testAuthenticateFailure");
        boolean result = user.authenticate("wrongpassword");
        assertFalse(result);
        System.out.println("Authentication with incorrect password failed as expected: " + result);
    }

    @Test
    @DisplayName("test: should deactivate user successfully")
    void testDeactivateUser() {
        System.out.println("Running testDeactivateUser");
        user.deactivate();
        assertFalse(user.isActive());
        System.out.println("User active status after deactivation: " + user.isActive());
    }

    @Test
    @DisplayName("test: should promote user to admin successfully")
    void testPromoteToAdmin() {
        System.out.println("Running testPromoteToAdmin");
        user.promoteToAdmin();
        assertTrue(user.isAdmin());
        System.out.println("User admin status after promotion: " + user.isAdmin());
    }
}
