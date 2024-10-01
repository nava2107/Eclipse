package com.example.application.views.register;

import classes.AuthService;
import classes.EmailService;
import classes.User;
import classes.UserRepository;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import java.awt.*;

@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "register")
public class Register extends Composite<VerticalLayout> {
    private final AuthService authService;
    public Register() {

        UserRepository userRepository = new UserRepository(); // Replace with actual instance
        EmailService emailService = new EmailService(); // Replace with actual instance
        this.authService = new AuthService(userRepository, emailService);

        this.addClassName("register-view");
        this.getElement().getStyle().set("background-color", "rgba(1, 1, 1, 0.5)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-register");
        getContent().add(container);

        Div innerC = new Div();
        innerC.addClassName("inner-div");
        container.add(innerC);

        H3 h3 = new H3();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField usernameField = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();

        h3.setText("Set up your account");
        h3.setWidth("100%");
        firstNameField.setLabel("First Name");
        lastNameField.setLabel("Last Name");
        usernameField.setLabel("Choose an username:");
        emailField.setLabel("Email");
        passwordField.setLabel("Password field");
        passwordField.setWidth("min-content");

        h3.addClassName("set-up");
        firstNameField.setClassName("name-field");
        lastNameField.setClassName("lastname-field");
        usernameField.setClassName("username-field");
        emailField.setClassName("email-field");
        passwordField.setClassName("password-field");

        innerC.add(h3, firstNameField, lastNameField, usernameField, emailField, passwordField);

        Div buttonDiv = new Div();
        buttonDiv.addClassName("button-div");

        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();

        buttonPrimary.setText("Continue");
        buttonSecondary.setText("Cancel");
        buttonPrimary.setClassName("primary-register");
        buttonSecondary.setClassName("secondary-register");

        container.add(buttonDiv);
        buttonDiv.add(buttonPrimary, buttonSecondary);

        buttonPrimary.addClickListener(event -> {
            String firstName = firstNameField.getValue();
            String lastName = lastNameField.getValue();
            String username = usernameField.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();

            // Perform basic validation
            if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Notification.show("All fields must be filled", 3000, Notification.Position.MIDDLE);
                return;
            }

            // Call the register method
            User user = authService.register(firstName, lastName, username, email, password);

            if (user != null) { // Check if the returned User object is not null
                Notification.show("Registration successful! Please verify your email.", 3000, Notification.Position.MIDDLE);
                // Redirect or perform other actions after success
            } else {
                Notification.show("Registration failed. Try again.", 3000, Notification.Position.MIDDLE);
            }
        });

    }

}
