package com.example.application.views.register;

import com.example.application.classes.AuthService;
import com.example.application.classes.EmailService;
import com.example.application.classes.User;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Register")
@Route(value = "register")
public class Register extends Composite<VerticalLayout> {

    private final AuthService authService;
    private final EmailService emailService;

    @Autowired
    public Register(AuthService authService, EmailService emailService) {
        this.authService = authService;
        this.emailService = emailService;

        // Set up layout styling
        this.addClassName("register-view");
        this.getElement().getStyle().set("background-color", "rgba(1, 1, 1, 0.5)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        // Main container
        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-register");
        getContent().add(container);

        // Inner container
        Div innerC = new Div();
        innerC.addClassName("inner-div");
        container.add(innerC);

        // Form fields and heading
        H3 h3 = new H3("Set up your account");
        TextField firstNameField = new TextField("First Name");
        TextField lastNameField = new TextField("Last Name");
        TextField usernameField = new TextField("Choose a username");
        EmailField emailField = new EmailField("Email");
        PasswordField passwordField = new PasswordField("Password");

        passwordField.setWidth("min-content");

        // Add CSS class names
        h3.addClassName("set-up");
        firstNameField.setClassName("name-field");
        lastNameField.setClassName("lastname-field");
        usernameField.setClassName("username-field");
        emailField.setClassName("email-field");
        passwordField.setClassName("password-field");

        innerC.add(h3, firstNameField, lastNameField, usernameField, emailField, passwordField);

        // Buttons
        Div buttonDiv = new Div();
        buttonDiv.addClassName("button-div");
        Button buttonPrimary = new Button("Continue");
        Button buttonSecondary = new Button("Cancel");

        buttonPrimary.setClassName("primary-register");
        buttonSecondary.setClassName("secondary-register");

        container.add(buttonDiv);
        buttonDiv.add(buttonPrimary, buttonSecondary);

        // Button logic
        buttonPrimary.addClickListener(event -> {
            System.out.println("Continue button clicked");

            String firstName = firstNameField.getValue();
            String lastName = lastNameField.getValue();
            String username = usernameField.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();

            // Basic validation
            if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Notification.show("All fields must be filled", 3000, Notification.Position.MIDDLE);
                System.out.println("Validation failed: Missing fields");
                return;
            }

            // Check if email is already registered
            if (authService.getUserRepository().findByEmail(email) != null) {
                Notification.show("Email is already registered.", 3000, Notification.Position.MIDDLE);
                return;
            }

            // Register the user through AuthService
            User newUser = authService.registerUser(username, firstName, lastName, email, password);
            if (newUser != null) {
                Notification.show("Registration successful! A verification email has been sent.", 3000, Notification.Position.MIDDLE);
                System.out.println("Registration successful: " + username);

                // Generate verification code
                String verificationCode = "verif-" + Math.random();
                System.out.println("Generated verification code: " + verificationCode);

                // Send verification email
                emailService.sendVerificationEmail(email, verificationCode);
                System.out.println("Verification email sent to: " + email);
            } else {
                Notification.show("Registration failed. Please try again.", 3000, Notification.Position.MIDDLE);
                System.out.println("Registration failed");
            }
        });

        // Cancel button logic (optional: clears all fields)
        buttonSecondary.addClickListener(event -> {
            firstNameField.clear();
            lastNameField.clear();
            usernameField.clear();
            emailField.clear();
            passwordField.clear();
        });
    }
}
