package com.example.application.views.signin;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
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

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-login");

        Div logo = new Div();
        logo.addClassName("logo");
        H1 eclipse = new H1("Eclipse");
        H1 eclipse2 = new H1("Eclipse");
        eclipse.addClassName("top");
        eclipse2.addClassName("bottom");
        logo.add(eclipse,eclipse2);
        container.add(logo);

        getContent().add(container);

        Div mainBox = new Div();

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            Notification.show("Login Successful! Redirecting...", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("main-view"));
        });

        mainBox.add(loginForm);

        Div bottomContainer = new Div();
        bottomContainer.addClassName("bottom-div-login");


        Div divJoinFamily =new Div();
        divJoinFamily.addClassName("join-family-link");

        Anchor signUpLink = new Anchor("register", "Join our Eclipse family here!");
        signUpLink.addClassName("join-here");

        divJoinFamily.add(new Span("Not a member?"), signUpLink);

        mainBox.add(divJoinFamily);

        container.add(mainBox);



    }
}
