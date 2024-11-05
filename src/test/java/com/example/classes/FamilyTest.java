package com.example.classes;

import com.example.application.classes.Devices.Device;
import com.example.application.classes.Family;
import com.example.application.classes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Family Class Tests")
class FamilyTest {

    private User admin;
    private Family family;

    @BeforeEach
    void setUp() {
        admin = new User("adminUser", "Admin", "User", "admin@example.com", "password123");
        family = new Family("Smith Family", admin);
        System.out.println("Family instance created for testing.");
    }

    @Test
    @DisplayName("test: Should add admin as initial family member")
    void testAdminIsInitialFamilyMember() {
        assertTrue(family.getFamilyMembers().contains(admin));
        assertEquals(1, family.getFamilyMembers().size());
        System.out.println("Verified admin as initial family member.");
    }

    @Test
    @DisplayName("test: Should add family member with correct QR code")
    void testAddFamilyMemberWithQRCode_Success() {
        User newMember = new User("newUser", "New", "User", "newuser@example.com", "password123");
        String qrCode = family.getQrCode();
        boolean added = family.addFamilyMemberWithQRCode(newMember, qrCode);
        assertTrue(added);
        assertTrue(family.getFamilyMembers().contains(newMember));
        System.out.println("New member added successfully with QR code.");
    }

    @Test
    @DisplayName("test: Should not add family member with incorrect QR code")
    void testAddFamilyMemberWithQRCode_Fail() {
        User newMember = new User("newUser", "New", "User", "newuser@example.com", "password123");
        String wrongQrCode = UUID.randomUUID().toString();
        boolean added = family.addFamilyMemberWithQRCode(newMember, wrongQrCode);
        assertFalse(added);
        assertFalse(family.getFamilyMembers().contains(newMember));
        System.out.println("Failed to add member with incorrect QR code as expected.");
    }

    @Test
    @DisplayName("test: Should add and remove family members")
    void testAddAndRemoveFamilyMembers() {
        User member = new User("testUser", "Test", "User", "testuser@example.com", "password123");
        family.addFamilyMember(member);
        assertTrue(family.getFamilyMembers().contains(member));

        family.removeFamilyMember(member);
        assertFalse(family.getFamilyMembers().contains(member));
        System.out.println("Member added and removed successfully.");
    }


    @Test
    @DisplayName("test: Should update family name")
    void testUpdateFamilyName() {
        String newName = "Example Family";
        family.setFamilyName(newName);
        assertEquals(newName, family.getFamilyName());
        System.out.println("Family name updated successfully.");
    }

    @Test
    @DisplayName("test: Should set and get family admin")
    void testSetAndGetAdmin() {
        User newAdmin = new User("newAdmin", "New", "Admin", "newadmin@example.com", "password123");
        family.setAdmin(newAdmin);
        assertEquals(newAdmin, family.getAdmin());
        System.out.println("Family admin updated successfully.");
    }
}


