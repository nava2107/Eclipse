package com.example.application.views.signin;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
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

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().getStyle().set("min-height", "100vh");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-login");

        Div title = new Div();

        Div logo = new Div();
        logo.addClassName("logo");
        H1 eclipse = new H1("Eclipse");
        H1 eclipse2 = new H1("Eclipse");
        eclipse.addClassName("top");
        eclipse2.addClassName("bottom");
        logo.add(eclipse,eclipse2);

        title.add(logo);

        Div moon = new Div();
        moon.addClassName("moon");
        Div moon1 = new Div();
        Div moon2 = new Div();
        Div moon3 = new Div();
        Div moon4 = new Div();
        Div moon5 = new Div();
        Div moon6 = new Div();
        Div moon7 = new Div();

        moon.add(moon1,moon2,moon3,moon4,moon5, moon7, moon6);


        getContent().add(container);
        container.add(title, moon);

        Div mainBox = new Div();
        mainBox.addClassName("main-box");
        Div shadowBox = new Div();
        shadowBox.addClassName("shadow-box-login");

        LoginForm loginForm = new LoginForm();
        loginForm.addClassName("loginform");
        loginForm.addLoginListener(event -> {
            Notification.show("Login Successful! Redirecting...", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("main-view"));
        });

        mainBox.add(shadowBox,loginForm);

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
