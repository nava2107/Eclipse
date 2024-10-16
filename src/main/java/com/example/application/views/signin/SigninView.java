package com.example.application.views.signin;

import com.example.application.classes.AuthService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Sign in")
@Route(value = "")
public class SigninView extends Composite<VerticalLayout> {

    @Autowired
    private AuthService authService;

    public SigninView() {
        this.addClassName("sign-in-view");
        this.getElement().getStyle().set("background-color", "rgba(1, 1, 1, 0.5)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-login");
        getContent().add(container);

        LoginForm loginForm = new LoginForm();
        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");
        content.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        content.setAlignItems(FlexComponent.Alignment.CENTER);

        container.add(loginForm);

        loginForm.addLoginListener(event -> {
            String username = event.getUsername();
            String password = event.getPassword();

            boolean isAuthenticated = authService.login(username, password);
            if (isAuthenticated) {
                Notification.show("Login Successful! Redirecting...", 3000, Notification.Position.MIDDLE);
                getUI().ifPresent(ui -> ui.navigate("main-view"));
            } else {

                loginForm.setError(true);
                Notification.show("Invalid credentials or email not verified", 3000, Notification.Position.MIDDLE);
            }
        });

        // Add the rest of the layout for sign-up link
        Div bottomContainer = new Div();
        bottomContainer.getElement().getStyle().setWidth("100%");
        container.add(bottomContainer);
        bottomContainer.addClassName("bottom-div-login");

        VerticalLayout layoutLink = new VerticalLayout();
        layoutLink.addClassName("layout-link");

        Anchor signUpLink = new Anchor("register", "Join our Eclipse family here!");
        signUpLink.addClassName("join-here");

        layoutLink.add(new Span("Not a member?"));
        layoutLink.add(signUpLink);

        bottomContainer.add(layoutLink);
    }
}
