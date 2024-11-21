package com.example.application.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInitialsGenerator {

    private static final String DB_URL = "jdbc:h2:file:./eclipsedatabase";
    private static final String DB_USER = "testbruker1";
    private static final String DB_PASSWORD = "test123";

    public static void main(String[] args) {
        UserInitialsGenerator generator = new UserInitialsGenerator();
        generator.printUserInitials();
    }

    public void printUserInitials() {
        String query = "SELECT FIRST_NAME, LAST_NAME, USERID FROM \"USERS\"";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String userId = rs.getString("USERID");

                String initials = generateInitials(firstName, lastName);
                System.out.printf("USERID: %s, Initials: %s%n", userId, initials);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private String generateInitials(String firstName, String lastName) {
        char firstInitial = firstName != null && !firstName.isEmpty() ? firstName.charAt(0) : '?';
        char lastInitial = lastName != null && !lastName.isEmpty() ? lastName.charAt(0) : '?';
        return String.valueOf(firstInitial).toUpperCase() + String.valueOf(lastInitial).toUpperCase();
    }
}
