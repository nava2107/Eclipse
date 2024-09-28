package com.example.application.views.signin;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
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
        this.addClassName("sign-in-view");
        this.getElement().getStyle().set("background-color", "rgba(17, 16, 24, 1)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        Div container = new Div();
        container.addClassName("div-login");
        container.getElement().getStyle().set("background-image", "url('moon.jpeg')");
        container.getElement().getStyle().set("background-size", "cover");
        container.getElement().getStyle().set("background-position", "center");
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        getContent().add(container);

        LoginForm loginForm = new LoginForm();
        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");
        content.setJustifyContentMode(JustifyContentMode.START);
        content.setAlignItems(Alignment.CENTER);

        container.add(loginForm);

        // listener for login
        loginForm.addLoginListener(event -> {
            // Simulate successful login
            Notification.show("Login Successful! Redirecting...", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("home")); // Replace "home" with your target route
        });

        Div bottomContainer = new Div();
        container.add(bottomContainer);

        bottomContainer.addClassName("bottom-div-login");
        Anchor signUpLink = new Anchor("https://example.com", "Not a member?\n Join our Eclipse family here!");
        signUpLink.getElement().getStyle().set("margin-top", "5px"); // Add some space
        bottomContainer.add(signUpLink);
    }
}
