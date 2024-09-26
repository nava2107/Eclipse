package com.example.application.views.signin;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Sign in")
@Menu(icon = "line-awesome/svg/user.svg", order = 0)
@Route(value = "")
public class SigninView extends Composite<VerticalLayout> {

    public SigninView() {
        LoginForm loginForm = new LoginForm();

        // Configure layout properties
        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");
        content.setJustifyContentMode(JustifyContentMode.START);
        content.setAlignItems(Alignment.CENTER);

        // login form til layout
        content.add(loginForm);

        // listener for login
        loginForm.addLoginListener(event -> {
            // Simulate successful login
            Notification.show("Login Successful! Redirecting...", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("home")); // Replace "home" with your target route
        });

        // Add Sign Up link
        Anchor signUpLink = new Anchor("https://example.com/signup", "Not a member? Join our Eclipse family here!");
        signUpLink.getElement().getStyle().set("margin-top", "5px"); // Add some space
        content.add(signUpLink);
    }
}
