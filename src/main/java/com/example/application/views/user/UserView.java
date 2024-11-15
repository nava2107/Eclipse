package com.example.application.views.user;

import com.example.application.addons.RedirectCard;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;


@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "user-view")
public class UserView extends Composite<VerticalLayout> {
    public UserView() {
        getContent().addClassName("devices-view");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().getStyle().set("min-height", "100vh");

        Div container = new Div();
        container.addClassName("div-user");
        H1 titleDevices = new H1("Account");
        Div backDiv = new Div();
        backDiv.addClassName("back-account-div");
        Image icon = new Image("images/arrow-left.png", "back");
        icon.setWidth("25px");
        icon.addClassName("back-devices");
        icon.addClickListener((ComponentEventListener<ClickEvent<Image>>) click -> {
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/main-view"));
        });
        backDiv.add(icon, titleDevices);
        container.add(backDiv);

        Avatar avatar1 = new Avatar();
        avatar1.addClassName("avatar-user");
        avatar1.setName("Firstname Lastname");
        container.add(avatar1);

        Div buttonsUser = new Div();
        buttonsUser.addClassName("buttons-div-user");

        Button button1 = new Button("Delete Account");
        button1.setClassName("delete-account");
        button1.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/user-view"));
        });

        Button button2 = new Button("Sign Out");
        button2.setClassName("sign-out");
        button2.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401"));
        });

        buttonsUser.add(button1, button2);
        container.add(buttonsUser);



        Div notificationSettings = createDeviceSection("Notification settings", "");
        Div notifcards = new Div();
        notifcards.addClassName("device-cards");
        notifcards.add(
                new RedirectCard("Modify", "Push-notifications", "user-view"),
                new RedirectCard("Modify", "E-mail notifications", "user-view")
        );
        notificationSettings.add(notifcards);
        container.add(notificationSettings);

        Div householdSettings = createDeviceSection("Notification settings", "");
        Div householdcards = new Div();
        householdcards.addClassName("device-cards");
        householdcards.add(
                new RedirectCard("Modify", "Household members", "user-view"),
                new RedirectCard("Modify", "Household permission", "user-view")
        );
        householdSettings.add(householdcards);
        container.add(householdSettings);

        Div accountSettings = createDeviceSection("Notification settings", "");
        Div accoundcards = new Div();
        accoundcards.addClassName("device-cards");
        accoundcards.add(
                new RedirectCard("Modify", "Password and safety", "user-view"),
                new RedirectCard("Modify", "Personal information", "user-view")
        );
        accountSettings.add(accoundcards);


        container.add(accountSettings);

        getContent().add(container);

    }
    private Div createDeviceSection(String titleText, String linkText) {
        Div sectionDiv = new Div();
        sectionDiv.addClassName("device-section");

        H2 title = new H2(titleText);
        Paragraph viewLink = new Paragraph(linkText);
        viewLink.addClassName("view-link");

        sectionDiv.add(title, viewLink);
        return sectionDiv;
    }
}
