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
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

@PageTitle("Register")
@Route("register")
public class Register extends Composite<VerticalLayout> {

    private final AuthService authService;

    public Register() {
        // Replace with actual instances of UserRepository and EmailService if necessary
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();
        this.authService = new AuthService(userRepository, emailService);

        // Styling
        this.addClassName("register-view");
        this.getElement().getStyle().set("background-color", "rgba(1, 1, 1, 0.5)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        // Container for layout
        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-register");
        getContent().add(container);

        // Inner container for form
        Div innerC = new Div();
        innerC.addClassName("inner-div");
        container.add(innerC);

        // Heading
        H3 h3 = new H3("Set up your account");
        h3.setWidth("100%");
        innerC.add(h3);

        // Input fields
        TextField firstNameField = new TextField("First Name");
        TextField lastNameField = new TextField("Last Name");
        TextField usernameField = new TextField("Choose a username:");
        EmailField emailField = new EmailField("Email");
        PasswordField passwordField = new PasswordField("Password");

        innerC.add(firstNameField, lastNameField, usernameField, emailField, passwordField);

        // Buttons
        Div buttonDiv = new Div();
        buttonDiv.addClassName("button-div");

        Button buttonPrimary = new Button("Continue");
        Button buttonSecondary = new Button("Cancel");

        buttonPrimary.addClassName("primary-register");
        buttonSecondary.addClassName("secondary-register");

        container.add(buttonDiv);
        buttonDiv.add(buttonPrimary, buttonSecondary);

        // Action when "Continue" button is clicked
        buttonPrimary.addClickListener(event -> {
            // Retrieve input values
            String firstName = firstNameField.getValue();
            String lastName = lastNameField.getValue();
            String username = usernameField.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();

            // Input validation (basic example, more could be added)
            if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Notification.show("All fields must be filled", 3000, Notification.Position.MIDDLE);
                return;
            }

            // Call the AuthService to register the user
            try {
                User user = authService.register(lastName, email, password);
                Notification.show("Registration successful! Please check your email for verification.", 3000, Notification.Position.MIDDLE);
                // Optionally, redirect or take other actions after registration
                // getUI().ifPresent(ui -> ui.navigate("login")); // Example of redirecting to login
            } catch (Exception e) {
                Notification.show("Registration failed: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        // Action when "Cancel" button is clicked (navigate to another view or clear fields)
        buttonSecondary.addClickListener(event -> {
            // Optional: Clear the fields or redirect to another page
            firstNameField.clear();
            lastNameField.clear();
            usernameField.clear();
            emailField.clear();
            passwordField.clear();
            Notification.show("Registration cancelled", 2000, Notification.Position.MIDDLE);
        });
    }
}
