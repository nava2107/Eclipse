package com.example.application.views.register;

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

import java.awt.*;

@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "register")
public class Register extends Composite<VerticalLayout> {

    public Register() {
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
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField username = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();

        h3.setText("Set up your account");
        h3.setWidth("100%");
        textField.setLabel("First Name");
        textField2.setLabel("Last Name");
        username.setLabel("Choose an username:");
        emailField.setLabel("Email");
        passwordField.setLabel("Password field");
        passwordField.setWidth("min-content");

        h3.addClassName("set-up");
        textField.setClassName("name-field");
        textField2.setClassName("lastname-field");
        username.setClassName("username-field");
        emailField.setClassName("email-field");
        passwordField.setClassName("password-field");

        innerC.add(h3, textField, textField2, username, emailField, passwordField);

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



    }

}
